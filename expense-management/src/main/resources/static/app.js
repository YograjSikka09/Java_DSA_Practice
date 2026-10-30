/* =============================================================
   SpendWise – Student Expense Manager
   app.js  |  Connects to Spring Boot REST API on port 8888
   ============================================================= */

const API = (window.location.protocol.startsWith('http') && window.location.port === '8888')
  ? ''
  : 'http://localhost:8888';

// ── cache ──────────────────────────────────────────────────────
let students   = [];
let categories = [];
let expenses   = [];

// ── category emoji palette ─────────────────────────────────────
const CATEGORY_EMOJIS = ['🍕','📚','🚌','🎮','🏠','💊','👕','✈️','🎵','⚽','☕','🎨','💻','🛒','🎬','🏋️'];
const CATEGORY_COLORS = [
  'badge-purple','badge-green','badge-amber','badge-pink',
  'badge-blue','badge-teal','badge-rose','badge-orange','badge-gray'
];

// ── helpers ────────────────────────────────────────────────────
const fmt = (n) => '₹' + Number(n).toLocaleString('en-IN', { minimumFractionDigits: 2, maximumFractionDigits: 2 });

function categoryEmoji(id) {
  return CATEGORY_EMOJIS[(id - 1) % CATEGORY_EMOJIS.length] || '📌';
}

function categoryBadgeClass(id) {
  return CATEGORY_COLORS[(id - 1) % CATEGORY_COLORS.length] || 'badge-gray';
}

function categoryName(id) {
  const c = categories.find(c => c.id === id);
  return c ? c.name : `#${id}`;
}

function studentName(id) {
  const s = students.find(s => s.id === id);
  return s ? s.name : `#${id}`;
}

function formatDate(d) {
  if (!d) return '—';
  try {
    const dt = new Date(d);
    return dt.toLocaleDateString('en-IN', { day: '2-digit', month: 'short', year: 'numeric' });
  } catch { return d; }
}

// ── api wrapper ────────────────────────────────────────────────
async function apiFetch(path, method = 'GET', body = null) {
  const opts = {
    method,
    headers: { 'Content-Type': 'application/json' },
  };
  if (body) opts.body = JSON.stringify(body);
  const res = await fetch(API + path, opts);
  if (!res.ok) {
    const text = await res.text();
    throw new Error(text || `HTTP ${res.status}`);
  }
  const ct = res.headers.get('content-type') || '';
  if (ct.includes('application/json')) return res.json();
  return res.text();
}

// ── toast ──────────────────────────────────────────────────────
let toastTimer;
function showToast(msg, type = 'success') {
  const el = document.getElementById('toast');
  el.textContent = msg;
  el.className = `toast show ${type}`;
  clearTimeout(toastTimer);
  toastTimer = setTimeout(() => el.classList.remove('show'), 3200);
}

// ── sidebar & nav ──────────────────────────────────────────────
function toggleSidebar() {
  document.getElementById('sidebar').classList.toggle('open');
}

function showSection(name) {
  // hide all sections
  document.querySelectorAll('.section').forEach(s => s.classList.remove('active'));
  document.querySelectorAll('.nav-btn').forEach(b => b.classList.remove('active'));

  document.getElementById(`section-${name}`).classList.add('active');
  document.getElementById(`nav-${name}`).classList.add('active');
  document.getElementById('page-title').textContent =
    name.charAt(0).toUpperCase() + name.slice(1);

  // close mobile sidebar
  document.getElementById('sidebar').classList.remove('open');

  // load data for section
  if (name === 'dashboard')  loadDashboard();
  if (name === 'students')   loadStudents();
  if (name === 'categories') loadCategories();
  if (name === 'expenses')   loadExpenses();
}

// ── modals ─────────────────────────────────────────────────────
function openModal(id) {
  document.getElementById(id).classList.add('open');
}

function closeModal(id) {
  document.getElementById(id).classList.remove('open');
}

// close on overlay click
document.querySelectorAll('.modal-overlay').forEach(ov => {
  ov.addEventListener('click', e => {
    if (e.target === ov) ov.classList.remove('open');
  });
});

// close on Escape
document.addEventListener('keydown', e => {
  if (e.key === 'Escape') {
    document.querySelectorAll('.modal-overlay.open').forEach(m => m.classList.remove('open'));
  }
});

// ── topbar date ────────────────────────────────────────────────
function setDate() {
  const el = document.getElementById('topbar-date');
  el.textContent = new Date().toLocaleDateString('en-IN', {
    weekday: 'short', day: '2-digit', month: 'long', year: 'numeric'
  });
}

// ══════════════════════════════════════════════════════════════
//  DASHBOARD
// ══════════════════════════════════════════════════════════════
async function loadDashboard() {
  try {
    [students, categories, expenses] = await Promise.all([
      apiFetch('/students'),
      apiFetch('/categories'),
      apiFetch('/expenses'),
    ]);

    // stats
    document.getElementById('stat-students-val').textContent   = students.length;
    document.getElementById('stat-categories-val').textContent = categories.length;
    document.getElementById('stat-expenses-val').textContent   = expenses.length;

    const total = expenses.reduce((s, e) => s + e.amount, 0);
    document.getElementById('stat-total-val').textContent = fmt(total);

    renderRecentExpenses();
    renderStudentChart();
  } catch (err) {
    showToast('Failed to load dashboard: ' + err.message, 'error');
  }
}

function renderRecentExpenses() {
  const container = document.getElementById('recent-expenses-table');
  const recent = [...expenses].reverse().slice(0, 6);

  if (!recent.length) {
    container.innerHTML = '<div class="empty-state"><span class="empty-state-icon">💸</span>No expenses yet.</div>';
    return;
  }

  container.innerHTML = `
    <table>
      <thead>
        <tr>
          <th>Student</th>
          <th>Category</th>
          <th>Amount</th>
          <th>Date</th>
        </tr>
      </thead>
      <tbody>
        ${recent.map(e => `
          <tr>
            <td><strong>${studentName(e.studentId)}</strong></td>
            <td>
              <span class="badge ${categoryBadgeClass(e.categoryId)}">
                ${categoryEmoji(e.categoryId)} ${categoryName(e.categoryId)}
              </span>
            </td>
            <td class="amount-positive">${fmt(e.amount)}</td>
            <td>${formatDate(e.expenseDate)}</td>
          </tr>`).join('')}
      </tbody>
    </table>`;
}

function renderStudentChart() {
  const container = document.getElementById('student-chart-area');

  if (!students.length) {
    container.innerHTML = '<div class="empty-state">No students yet.</div>';
    return;
  }

  // aggregate per student
  const totals = students.map(s => ({
    name: s.name,
    total: expenses.filter(e => e.studentId === s.id).reduce((sum, e) => sum + e.amount, 0)
  })).sort((a, b) => b.total - a.total);

  const max = totals[0]?.total || 1;

  container.innerHTML = totals.map(t => `
    <div class="chart-bar-row">
      <div class="chart-bar-label" title="${t.name}">${t.name.split(' ')[0]}</div>
      <div class="chart-bar-track">
        <div class="chart-bar-fill" style="width:${(t.total / max * 100).toFixed(1)}%"></div>
      </div>
      <div class="chart-bar-val">${fmt(t.total)}</div>
    </div>`).join('');
}

// ══════════════════════════════════════════════════════════════
//  STUDENTS
// ══════════════════════════════════════════════════════════════
async function loadStudents() {
  try {
    students = await apiFetch('/students');
    renderStudentsTable(students);
  } catch (err) {
    showToast('Failed to load students: ' + err.message, 'error');
  }
}

function renderStudentsTable(data) {
  const container = document.getElementById('students-table');
  if (!data.length) {
    container.innerHTML = '<div class="empty-state"><span class="empty-state-icon">🎓</span>No students yet. Add one!</div>';
    return;
  }

  container.innerHTML = `
    <table>
      <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Email</th>
          <th>Total Spent</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        ${data.map(s => {
          const spent = expenses.filter(e => e.studentId === s.id).reduce((sum, e) => sum + e.amount, 0);
          return `
            <tr>
              <td><span class="badge badge-purple">${s.id}</span></td>
              <td><strong>${s.name}</strong></td>
              <td style="color:var(--clr-text-muted)">${s.email}</td>
              <td class="amount-positive">${fmt(spent)}</td>
              <td>
                <div class="actions-cell">
                  <button class="action-btn edit"   onclick="openEditStudent(${s.id})"   title="Edit">✏️</button>
                  <button class="action-btn delete" onclick="confirmDelete('student',${s.id})" title="Delete">🗑️</button>
                </div>
              </td>
            </tr>`;
        }).join('')}
      </tbody>
    </table>`;
}

function filterStudents() {
  const q = document.getElementById('student-search').value.toLowerCase();
  const filtered = students.filter(s =>
    s.name.toLowerCase().includes(q) || s.email.toLowerCase().includes(q)
  );
  renderStudentsTable(filtered);
}

// ── student modal ──────────────────────────────────────────────
function openAddStudent() {
  document.getElementById('student-id').value       = '';
  document.getElementById('student-name').value     = '';
  document.getElementById('student-email').value    = '';
  document.getElementById('student-modal-title').textContent  = 'Add Student';
  document.getElementById('student-submit-btn').textContent   = 'Add Student';
  openModal('student-modal');
}

async function openEditStudent(id) {
  const s = students.find(s => s.id === id);
  if (!s) return;
  document.getElementById('student-id').value      = s.id;
  document.getElementById('student-name').value    = s.name;
  document.getElementById('student-email').value   = s.email;
  document.getElementById('student-modal-title').textContent = 'Edit Student';
  document.getElementById('student-submit-btn').textContent  = 'Update Student';
  openModal('student-modal');
}

async function submitStudentForm(e) {
  e.preventDefault();
  const id    = document.getElementById('student-id').value;
  const name  = document.getElementById('student-name').value.trim();
  const email = document.getElementById('student-email').value.trim();
  const body  = { name, email };

  try {
    if (id) {
      await apiFetch(`/students/${id}`, 'PUT', body);
      showToast('Student updated successfully!', 'success');
    } else {
      await apiFetch('/students', 'POST', body);
      showToast('Student added successfully!', 'success');
    }
    closeModal('student-modal');
    loadStudents();
  } catch (err) {
    showToast('Error: ' + err.message, 'error');
  }
}


// ══════════════════════════════════════════════════════════════
//  CATEGORIES
// ══════════════════════════════════════════════════════════════
async function loadCategories() {
  try {
    categories = await apiFetch('/categories');
    renderCategoriesGrid();
  } catch (err) {
    showToast('Failed to load categories: ' + err.message, 'error');
  }
}

function renderCategoriesGrid() {
  const container = document.getElementById('categories-grid');
  if (!categories.length) {
    container.innerHTML = '<div class="empty-state" style="grid-column:1/-1"><span class="empty-state-icon">🏷️</span>No categories yet. Add one!</div>';
    return;
  }

  container.innerHTML = categories.map(c => `
    <div class="category-card">
      <span class="category-emoji">${categoryEmoji(c.id)}</span>
      <div class="category-name">${c.name}</div>
      <div class="category-actions">
        <button class="action-btn edit"   onclick="openEditCategory(${c.id})"   title="Edit">✏️</button>
        <button class="action-btn delete" onclick="confirmDelete('category',${c.id})" title="Delete">🗑️</button>
      </div>
    </div>`).join('');
}

// ── category modal ─────────────────────────────────────────────
function openAddCategory() {
  document.getElementById('category-id').value               = '';
  document.getElementById('category-name').value             = '';
  document.getElementById('category-modal-title').textContent= 'Add Category';
  document.getElementById('category-submit-btn').textContent = 'Add Category';
  openModal('category-modal');
}

async function openEditCategory(id) {
  const c = categories.find(c => c.id === id);
  if (!c) return;
  document.getElementById('category-id').value               = c.id;
  document.getElementById('category-name').value             = c.name;
  document.getElementById('category-modal-title').textContent= 'Edit Category';
  document.getElementById('category-submit-btn').textContent = 'Update Category';
  openModal('category-modal');
}

async function submitCategoryForm(e) {
  e.preventDefault();
  const id   = document.getElementById('category-id').value;
  const name = document.getElementById('category-name').value.trim();

  try {
    if (id) {
      await apiFetch(`/categories/${id}`, 'PUT', { name });
      showToast('Category updated!', 'success');
    } else {
      await apiFetch('/categories', 'POST', { name });
      showToast('Category added!', 'success');
    }
    closeModal('category-modal');
    loadCategories();
  } catch (err) {
    showToast('Error: ' + err.message, 'error');
  }
}


// ══════════════════════════════════════════════════════════════
//  EXPENSES
// ══════════════════════════════════════════════════════════════
async function loadExpenses() {
  try {
    [students, categories, expenses] = await Promise.all([
      apiFetch('/students'),
      apiFetch('/categories'),
      apiFetch('/expenses'),
    ]);
    populateExpenseFilterDropdown();
    renderExpensesTable(expenses);
  } catch (err) {
    showToast('Failed to load expenses: ' + err.message, 'error');
  }
}

function populateExpenseFilterDropdown() {
  const sel = document.getElementById('expense-filter-student');
  sel.innerHTML = '<option value="">All Students</option>' +
    students.map(s => `<option value="${s.id}">${s.name}</option>`).join('');
}

function renderExpensesTable(data) {
  const container = document.getElementById('expenses-table');
  if (!data.length) {
    container.innerHTML = '<div class="empty-state"><span class="empty-state-icon">💰</span>No expenses found.</div>';
    return;
  }

  container.innerHTML = `
    <table>
      <thead>
        <tr>
          <th>#</th>
          <th>Student</th>
          <th>Category</th>
          <th>Amount</th>
          <th>Date</th>
          <th>Description</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        ${[...data].reverse().map(e => `
          <tr>
            <td><span class="badge badge-gray">${e.id}</span></td>
            <td><strong>${studentName(e.studentId)}</strong></td>
            <td>
              <span class="badge ${categoryBadgeClass(e.categoryId)}">
                ${categoryEmoji(e.categoryId)} ${categoryName(e.categoryId)}
              </span>
            </td>
            <td class="amount-positive">${fmt(e.amount)}</td>
            <td style="color:var(--clr-text-muted);white-space:nowrap">${formatDate(e.expenseDate)}</td>
            <td style="color:var(--clr-text-muted);max-width:180px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap">${e.description || '—'}</td>
            <td>
              <div class="actions-cell">
                <button class="action-btn edit"   onclick="openEditExpense(${e.id})"   title="Edit">✏️</button>
                <button class="action-btn delete" onclick="confirmDelete('expense',${e.id})" title="Delete">🗑️</button>
              </div>
            </td>
          </tr>`).join('')}
      </tbody>
    </table>`;
}

function filterExpenses() {
  const q   = document.getElementById('expense-search').value.toLowerCase();
  const sid = document.getElementById('expense-filter-student').value;

  const filtered = expenses.filter(e => {
    const matchStudent  = !sid || String(e.studentId) === sid;
    const matchQuery    = !q
      || studentName(e.studentId).toLowerCase().includes(q)
      || categoryName(e.categoryId).toLowerCase().includes(q)
      || (e.description || '').toLowerCase().includes(q)
      || String(e.amount).includes(q);
    return matchStudent && matchQuery;
  });

  renderExpensesTable(filtered);
}

// ── expense modal ──────────────────────────────────────────────
function populateExpenseModalDropdowns() {
  const ssel = document.getElementById('expense-student');
  const csel = document.getElementById('expense-category');

  ssel.innerHTML = '<option value="">Select student…</option>' +
    students.map(s => `<option value="${s.id}">${s.name}</option>`).join('');

  csel.innerHTML = '<option value="">Select category…</option>' +
    categories.map(c => `<option value="${c.id}">${categoryEmoji(c.id)} ${c.name}</option>`).join('');
}

async function openAddExpense() {
  try {
    if (!students.length)   students   = await apiFetch('/students');
    if (!categories.length) categories = await apiFetch('/categories');
  } catch {}
  populateExpenseModalDropdowns();
  document.getElementById('expense-id').value      = '';
  document.getElementById('expense-student').value  = '';
  document.getElementById('expense-category').value = '';
  document.getElementById('expense-amount').value   = '';
  document.getElementById('expense-date').value     = new Date().toISOString().split('T')[0];
  document.getElementById('expense-desc').value     = '';
  document.getElementById('expense-modal-title').textContent = 'Add Expense';
  document.getElementById('expense-submit-btn').textContent  = 'Add Expense';
  openModal('expense-modal');
}

async function openEditExpense(id) {
  const ex = expenses.find(e => e.id === id);
  if (!ex) return;
  try {
    if (!students.length)   students   = await apiFetch('/students');
    if (!categories.length) categories = await apiFetch('/categories');
  } catch {}
  populateExpenseModalDropdowns();
  document.getElementById('expense-id').value      = ex.id;
  document.getElementById('expense-student').value  = ex.studentId;
  document.getElementById('expense-category').value = ex.categoryId;
  document.getElementById('expense-amount').value   = ex.amount;
  document.getElementById('expense-date').value     = ex.expenseDate || '';
  document.getElementById('expense-desc').value     = ex.description || '';
  document.getElementById('expense-modal-title').textContent = 'Edit Expense';
  document.getElementById('expense-submit-btn').textContent  = 'Update Expense';
  openModal('expense-modal');
}

async function submitExpenseForm(e) {
  e.preventDefault();
  const id          = document.getElementById('expense-id').value;
  const studentId   = Number(document.getElementById('expense-student').value);
  const categoryId  = Number(document.getElementById('expense-category').value);
  const amount      = parseFloat(document.getElementById('expense-amount').value);
  const expenseDate = document.getElementById('expense-date').value;
  const description = document.getElementById('expense-desc').value.trim();

  const body = { studentId, categoryId, amount, expenseDate, description };

  try {
    if (id) {
      await apiFetch(`/expenses/${id}`, 'PUT', body);
      showToast('Expense updated!', 'success');
    } else {
      await apiFetch('/expenses', 'POST', body);
      showToast('Expense added!', 'success');
    }
    closeModal('expense-modal');
    loadExpenses();
  } catch (err) {
    showToast('Error: ' + err.message, 'error');
  }
}


// ══════════════════════════════════════════════════════════════
//  CONFIRM DELETE
// ══════════════════════════════════════════════════════════════
function confirmDelete(type, id) {
  const msgs = {
    student:  'Are you sure you want to delete this student? All their expense records will remain but will lose the student reference.',
    category: 'Are you sure you want to delete this category?',
    expense:  'Are you sure you want to delete this expense? This action cannot be undone.',
  };
  document.getElementById('confirm-msg').textContent = msgs[type];

  const btn = document.getElementById('confirm-delete-btn');
  // remove old listener
  const newBtn = btn.cloneNode(true);
  btn.parentNode.replaceChild(newBtn, btn);

  newBtn.addEventListener('click', async () => {
    try {
      await apiFetch(`/${type}s/${id}`, 'DELETE');
      showToast(`${type.charAt(0).toUpperCase() + type.slice(1)} deleted.`, 'success');
      closeModal('confirm-modal');

      if (type === 'student')  loadStudents();
      if (type === 'category') loadCategories();
      if (type === 'expense')  loadExpenses();
    } catch (err) {
      showToast('Delete failed: ' + err.message, 'error');
      closeModal('confirm-modal');
    }
  });

  openModal('confirm-modal');
}

// ══════════════════════════════════════════════════════════════
//  INIT
// ══════════════════════════════════════════════════════════════
async function init() {
  setDate();

  // pre-load students & categories into cache quietly
  try {
    [students, categories] = await Promise.all([
      apiFetch('/students'),
      apiFetch('/categories'),
    ]);
  } catch { /* will retry per section */ }

  loadDashboard();
}

init();
