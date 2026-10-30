/* ═══════════════════════════════════
   EduTrack — Student Management JS
   REST API: Spring Boot /students
   ═══════════════════════════════════ */

const API_BASE = '/students';

/* ── State ── */
let allStudents   = [];
let filteredStudents = [];
let sortField     = null;
let sortAsc       = true;
let deleteTargetId = null;
let editingId     = null;

/* ════════════════════════════════
   INIT
   ════════════════════════════════ */
document.addEventListener('DOMContentLoaded', () => {
  fetchStudents();
});

/* ════════════════════════════════
   NAVIGATION
   ════════════════════════════════ */
function showSection(name) {
  // Hide all
  document.querySelectorAll('.section').forEach(s => s.classList.add('hidden'));
  document.querySelectorAll('.nav-item').forEach(n => n.classList.remove('active'));

  // Show target
  document.getElementById(`section-${name}`).classList.remove('hidden');
  const navEl = document.getElementById(`nav-${name}`);
  if (navEl) navEl.classList.add('active');

  // Breadcrumb
  const labels = { dashboard: 'Dashboard', students: 'All Students', add: editingId ? 'Edit Student' : 'Add Student' };
  document.getElementById('breadcrumb').textContent = labels[name] || name;

  // Re-render on tab switch
  if (name === 'students') renderStudentsTable(filteredStudents);
  if (name === 'dashboard') renderDashboard();
  if (name === 'add' && !editingId) resetForm();

  // Close sidebar on mobile
  if (window.innerWidth < 768) closeSidebar();
}

function toggleSidebar() {
  document.getElementById('sidebar').classList.toggle('open');
}
function closeSidebar() {
  document.getElementById('sidebar').classList.remove('open');
}

/* ════════════════════════════════
   FETCH ALL STUDENTS
   ════════════════════════════════ */
async function fetchStudents() {
  try {
    const res = await fetch(API_BASE);
    if (!res.ok) throw new Error(`HTTP ${res.status}`);
    allStudents = await res.json();
    filteredStudents = [...allStudents];
    renderDashboard();
    renderStudentsTable(filteredStudents);
    updateCoursePills();
    updateCourseFilter();
    updateStats();
  } catch (err) {
    showToast('Could not connect to server. Showing demo data.', 'warning');
    loadDemoData();
  }
}

function loadDemoData() {
  allStudents = [
    { id: 1, name: 'Aarav Sharma',   email: 'aarav@example.com',   course: 'Computer Science', age: 20 },
    { id: 2, name: 'Priya Patel',    email: 'priya@example.com',   course: 'Data Science',     age: 22 },
    { id: 3, name: 'Rohan Mehta',    email: 'rohan@example.com',   course: 'Web Development',  age: 19 },
    { id: 4, name: 'Sneha Gupta',    email: 'sneha@example.com',   course: 'AI & ML',          age: 21 },
    { id: 5, name: 'Vikram Reddy',   email: 'vikram@example.com',  course: 'Computer Science', age: 23 },
  ];
  filteredStudents = [...allStudents];
  renderDashboard();
  renderStudentsTable(filteredStudents);
  updateCoursePills();
  updateCourseFilter();
  updateStats();
}

/* ════════════════════════════════
   STATS & DASHBOARD
   ════════════════════════════════ */
function updateStats() {
  const total    = allStudents.length;
  const courses  = new Set(allStudents.map(s => s.course)).size;
  const avgAge   = total ? Math.round(allStudents.reduce((s, x) => s + x.age, 0) / total) : 0;
  const latest   = allStudents.at(-1);

  animateCount('stat-total',   total);
  animateCount('stat-courses', courses);
  animateCount('stat-age',     avgAge);
  document.getElementById('stat-latest').textContent = latest ? latest.name.split(' ')[0] : '—';
}

function animateCount(id, target) {
  const el = document.getElementById(id);
  const start = parseInt(el.textContent) || 0;
  const dur = 600;
  const startTime = performance.now();
  function step(now) {
    const progress = Math.min((now - startTime) / dur, 1);
    el.textContent = Math.round(start + (target - start) * easeOut(progress));
    if (progress < 1) requestAnimationFrame(step);
  }
  requestAnimationFrame(step);
}
function easeOut(t) { return 1 - Math.pow(1 - t, 3); }

function renderDashboard() {
  updateStats();
  const tbody = document.getElementById('dashboard-tbody');
  const recent = [...allStudents].slice(-5).reverse();
  if (!recent.length) {
    tbody.innerHTML = `<tr class="empty-row"><td colspan="6"><div class="empty-state"><div class="empty-icon">📚</div><p>No students yet. <a href="#" onclick="showSection('add')">Add one now!</a></p></div></td></tr>`;
    return;
  }
  tbody.innerHTML = recent.map(s => buildRow(s)).join('');
}

/* ════════════════════════════════
   RENDER STUDENTS TABLE
   ════════════════════════════════ */
function renderStudentsTable(students) {
  const tbody = document.getElementById('students-tbody');
  document.getElementById('record-count').textContent = `${students.length} record${students.length !== 1 ? 's' : ''}`;

  if (!students.length) {
    tbody.innerHTML = `<tr class="empty-row"><td colspan="6"><div class="empty-state"><div class="empty-icon">🎓</div><p>No student records found.</p></div></td></tr>`;
    return;
  }
  tbody.innerHTML = students.map(s => buildRow(s)).join('');
}

function buildRow(s) {
  const initials = getInitials(s.name);
  const avatarColor = stringToColor(s.name);
  return `
    <tr data-id="${s.id}">
      <td><span class="td-id">#${s.id}</span></td>
      <td>
        <div class="td-name">
          <div class="td-avatar" style="background:${avatarColor}">${initials}</div>
          ${escHtml(s.name)}
        </div>
      </td>
      <td><span class="td-email">${escHtml(s.email)}</span></td>
      <td><span class="pill pill-course">${escHtml(s.course)}</span></td>
      <td><span class="pill pill-age">${s.age} yrs</span></td>
      <td>
        <div class="actions-cell">
          <button class="btn-icon view"   title="View"   onclick="viewStudent(${s.id})">
            <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"/><circle cx="12" cy="12" r="3"/></svg>
          </button>
          <button class="btn-icon edit"   title="Edit"   onclick="editStudent(${s.id})">
            <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"/><path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"/></svg>
          </button>
          <button class="btn-icon delete" title="Delete" onclick="openDeleteModal(${s.id}, '${escHtml(s.name)}')">
            <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><polyline points="3 6 5 6 21 6"/><path d="M19 6l-1 14a2 2 0 0 1-2 2H8a2 2 0 0 1-2-2L5 6"/><path d="M10 11v6"/><path d="M14 11v6"/></svg>
          </button>
        </div>
      </td>
    </tr>`;
}

/* ════════════════════════════════
   VIEW STUDENT MODAL
   ════════════════════════════════ */
function viewStudent(id) {
  const s = allStudents.find(x => x.id === id);
  if (!s) return;
  document.getElementById('viewAvatar').textContent        = getInitials(s.name);
  document.getElementById('viewAvatar').style.background  = stringToColor(s.name);
  document.getElementById('viewName').textContent          = s.name;
  document.getElementById('viewCourse').textContent        = s.course;
  document.getElementById('viewId').textContent            = `#${s.id}`;
  document.getElementById('viewEmail').textContent         = s.email;
  document.getElementById('viewAge').textContent           = `${s.age} years`;
  document.getElementById('viewCourseField').textContent   = s.course;
  document.getElementById('viewEditBtn').onclick           = () => { closeModal('viewModal'); editStudent(id); };
  openModal('viewModal');
}

/* ════════════════════════════════
   ADD / EDIT STUDENT FORM
   ════════════════════════════════ */
function editStudent(id) {
  const s = allStudents.find(x => x.id === id);
  if (!s) return;

  editingId = id;
  document.getElementById('studentId').value    = s.id;
  document.getElementById('studentName').value  = s.name;
  document.getElementById('studentEmail').value = s.email;
  document.getElementById('studentCourse').value= s.course;
  document.getElementById('studentAge').value   = s.age;

  document.getElementById('form-title').textContent    = 'Edit Student';
  document.getElementById('form-subtitle').textContent = `Updating record for ${s.name}`;
  document.getElementById('submitBtnText').textContent = 'Update Student';
  document.getElementById('breadcrumb').textContent    = 'Edit Student';

  updateFormAvatar();
  showSection('add');

  // Patch nav
  document.querySelectorAll('.nav-item').forEach(n => n.classList.remove('active'));
  document.getElementById('nav-add').classList.add('active');
}

function resetForm() {
  editingId = null;
  document.getElementById('studentForm').reset();
  document.getElementById('studentId').value = '';
  document.getElementById('form-title').textContent    = 'Add New Student';
  document.getElementById('form-subtitle').textContent = 'Fill in the details to enroll a student';
  document.getElementById('submitBtnText').textContent = 'Save Student';
  document.getElementById('form-avatar-name').textContent = 'New Student';
  document.getElementById('form-avatar').textContent = '';
  document.getElementById('form-avatar').innerHTML = `<svg width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"/><circle cx="12" cy="7" r="4"/></svg>`;
  clearErrors();
}

function updateFormAvatar() {
  const name = document.getElementById('studentName').value.trim();
  const avatarEl = document.getElementById('form-avatar');
  const nameEl = document.getElementById('form-avatar-name');
  if (name) {
    const initials = getInitials(name);
    avatarEl.textContent = initials;
    avatarEl.style.background = stringToColor(name);
    avatarEl.style.color = '#fff';
    avatarEl.style.border = 'none';
    nameEl.textContent = name;
  } else {
    avatarEl.innerHTML = `<svg width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"/><circle cx="12" cy="7" r="4"/></svg>`;
    avatarEl.style.background = '';
    avatarEl.style.color = '';
    avatarEl.style.border = '';
    nameEl.textContent = 'New Student';
  }
}

/* ════════════════════════════════
   FORM SUBMIT
   ════════════════════════════════ */
async function handleFormSubmit(e) {
  e.preventDefault();
  clearErrors();

  const name   = document.getElementById('studentName').value.trim();
  const email  = document.getElementById('studentEmail').value.trim();
  const course = document.getElementById('studentCourse').value.trim();
  const age    = parseInt(document.getElementById('studentAge').value);

  let valid = true;

  if (!name) { setError('err-name', 'Name is required'); valid = false; }
  if (!email || !isValidEmail(email)) { setError('err-email', 'Enter a valid email address'); valid = false; }
  if (!course) { setError('err-course', 'Course is required'); valid = false; }
  if (!age || age < 5 || age > 100) { setError('err-age', 'Age must be between 5 and 100'); valid = false; }

  if (!valid) return;

  const payload = { name, email, course, age };
  const btn = document.getElementById('submitBtn');
  btn.disabled = true;
  btn.innerHTML = `<svg class="spin" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5"><path d="M21 12a9 9 0 1 1-6.219-8.56"/></svg> Saving…`;

  try {
    let res;
    if (editingId) {
      res = await fetch(`${API_BASE}/${editingId}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload),
      });
    } else {
      res = await fetch(API_BASE, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload),
      });
    }

    if (!res.ok) throw new Error(`HTTP ${res.status}`);
    const saved = await res.json();

    if (editingId) {
      const idx = allStudents.findIndex(s => s.id === editingId);
      if (idx !== -1) allStudents[idx] = saved;
      showToast(`✏️ ${saved.name}'s record updated!`, 'success');
    } else {
      allStudents.push(saved);
      showToast(`🎉 ${saved.name} enrolled successfully!`, 'success');
    }

    filteredStudents = [...allStudents];
    updateStats();
    updateCoursePills();
    updateCourseFilter();
    resetForm();
    showSection('students');

  } catch (err) {
    // Offline/demo mode — simulate locally
    if (editingId) {
      const idx = allStudents.findIndex(s => s.id === editingId);
      if (idx !== -1) allStudents[idx] = { ...allStudents[idx], ...payload };
      showToast(`✏️ Updated locally (server offline)`, 'warning');
    } else {
      const newId = allStudents.length ? Math.max(...allStudents.map(s => s.id)) + 1 : 1;
      allStudents.push({ id: newId, ...payload });
      showToast(`🎉 Added locally (server offline)`, 'warning');
    }
    filteredStudents = [...allStudents];
    updateStats();
    updateCoursePills();
    updateCourseFilter();
    resetForm();
    showSection('students');
  } finally {
    btn.disabled = false;
    btn.innerHTML = `<svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5"><polyline points="20 6 9 17 4 12"/></svg> <span id="submitBtnText">${editingId ? 'Update Student' : 'Save Student'}</span>`;
  }
}

/* ════════════════════════════════
   DELETE
   ════════════════════════════════ */
function openDeleteModal(id, name) {
  deleteTargetId = id;
  document.getElementById('deleteModalBody').textContent = `Are you sure you want to delete ${name}? This action cannot be undone.`;
  openModal('deleteModal');
}

async function confirmDelete() {
  if (!deleteTargetId) return;
  const btn = document.getElementById('confirmDeleteBtn');
  btn.disabled = true;
  btn.textContent = 'Deleting…';

  try {
    const res = await fetch(`${API_BASE}/${deleteTargetId}`, { method: 'DELETE' });
    if (!res.ok && res.status !== 204) throw new Error(`HTTP ${res.status}`);
  } catch (err) {
    // offline — remove locally
  } finally {
    const name = allStudents.find(s => s.id === deleteTargetId)?.name || 'Student';
    allStudents = allStudents.filter(s => s.id !== deleteTargetId);
    filteredStudents = filteredStudents.filter(s => s.id !== deleteTargetId);
    closeModal('deleteModal');
    renderStudentsTable(filteredStudents);
    renderDashboard();
    updateStats();
    updateCoursePills();
    updateCourseFilter();
    showToast(`🗑️ ${name} removed`, 'info');
    deleteTargetId = null;
    btn.disabled = false;
    btn.textContent = 'Yes, Delete';
  }
}

/* ════════════════════════════════
   SEARCH & FILTER
   ════════════════════════════════ */
function filterStudents(query) {
  // Sync both search inputs
  const q = query.toLowerCase();
  document.getElementById('globalSearch').value = q;
  document.getElementById('tableSearch').value  = q;

  const courseVal = document.getElementById('courseFilter').value;
  filteredStudents = allStudents.filter(s => {
    const matchQ = !q || s.name.toLowerCase().includes(q) || s.email.toLowerCase().includes(q) || s.course.toLowerCase().includes(q) || String(s.id).includes(q);
    const matchC = !courseVal || s.course === courseVal;
    return matchQ && matchC;
  });
  renderStudentsTable(filteredStudents);
}

function filterByCourse(course) {
  const q = document.getElementById('tableSearch').value.toLowerCase();
  filteredStudents = allStudents.filter(s => {
    const matchQ = !q || s.name.toLowerCase().includes(q) || s.email.toLowerCase().includes(q) || s.course.toLowerCase().includes(q);
    const matchC = !course || s.course === course;
    return matchQ && matchC;
  });
  renderStudentsTable(filteredStudents);
}

function updateCourseFilter() {
  const select = document.getElementById('courseFilter');
  const current = select.value;
  const courses = [...new Set(allStudents.map(s => s.course))].sort();
  select.innerHTML = `<option value="">All Courses</option>` + courses.map(c => `<option value="${escHtml(c)}" ${c === current ? 'selected' : ''}>${escHtml(c)}</option>`).join('');
}

/* ════════════════════════════════
   SORT
   ════════════════════════════════ */
function sortTable(field) {
  if (sortField === field) sortAsc = !sortAsc;
  else { sortField = field; sortAsc = true; }

  filteredStudents.sort((a, b) => {
    let va = a[field], vb = b[field];
    if (typeof va === 'string') va = va.toLowerCase();
    if (typeof vb === 'string') vb = vb.toLowerCase();
    if (va < vb) return sortAsc ? -1 : 1;
    if (va > vb) return sortAsc ? 1 : -1;
    return 0;
  });
  renderStudentsTable(filteredStudents);

  // Arrow UI
  document.querySelectorAll('.sort-arrow').forEach(a => a.textContent = '↕');
  const ths = document.querySelectorAll('#students-table thead th');
  const fields = ['id','name','email','course','age'];
  const idx = fields.indexOf(field);
  if (idx !== -1 && ths[idx]) ths[idx].querySelector('.sort-arrow').textContent = sortAsc ? '↑' : '↓';
}

/* ════════════════════════════════
   COURSE PILLS (add form)
   ════════════════════════════════ */
function updateCoursePills() {
  const container = document.getElementById('course-pills');
  const courses = [...new Set(allStudents.map(s => s.course))].slice(0, 8);
  if (!courses.length) {
    container.innerHTML = `<span class="pill-empty">No courses yet</span>`;
    return;
  }
  container.innerHTML = courses.map(c => `<span class="pill" onclick="document.getElementById('studentCourse').value='${escHtml(c)}';">${escHtml(c)}</span>`).join('');
}

/* ════════════════════════════════
   MODALS HELPERS
   ════════════════════════════════ */
function openModal(id) {
  document.getElementById(id).classList.add('open');
  document.body.style.overflow = 'hidden';
}
function closeModal(id) {
  document.getElementById(id).classList.remove('open');
  document.body.style.overflow = '';
}

// Close modal on overlay click
document.querySelectorAll('.modal-overlay').forEach(overlay => {
  overlay.addEventListener('click', e => {
    if (e.target === overlay) closeModal(overlay.id);
  });
});

// Close on ESC
document.addEventListener('keydown', e => {
  if (e.key === 'Escape') {
    document.querySelectorAll('.modal-overlay.open').forEach(m => closeModal(m.id));
  }
});

/* ════════════════════════════════
   TOAST
   ════════════════════════════════ */
function showToast(msg, type = 'info') {
  const icons = { success: '✅', error: '❌', warning: '⚠️', info: 'ℹ️' };
  const container = document.getElementById('toastContainer');
  const toast = document.createElement('div');
  toast.className = `toast ${type}`;
  toast.innerHTML = `<span class="toast-icon">${icons[type]}</span><span class="toast-msg">${msg}</span>`;
  container.appendChild(toast);
  setTimeout(() => {
    toast.classList.add('removing');
    toast.addEventListener('animationend', () => toast.remove());
  }, 3500);
}

/* ════════════════════════════════
   FORM VALIDATION HELPERS
   ════════════════════════════════ */
function setError(id, msg) {
  const el = document.getElementById(id);
  if (el) el.textContent = msg;
  const inputId = id.replace('err-', 'student') + (id === 'err-name' ? 'Name' : id === 'err-email' ? 'Email' : id === 'err-course' ? 'Course' : 'Age');
  const input = document.querySelector(`[id^="student${id.replace('err-', '').charAt(0).toUpperCase() + id.replace('err-', '').slice(1)}"]`);
  if (input) input.classList.add('error');
}
function clearErrors() {
  ['err-name','err-email','err-course','err-age'].forEach(id => {
    const el = document.getElementById(id);
    if (el) el.textContent = '';
  });
  document.querySelectorAll('.form-input').forEach(i => i.classList.remove('error'));
}
function isValidEmail(email) {
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

/* ════════════════════════════════
   UTILITIES
   ════════════════════════════════ */
function getInitials(name = '') {
  return name.split(' ').filter(Boolean).slice(0, 2).map(w => w[0].toUpperCase()).join('');
}

function stringToColor(str = '') {
  const palette = [
    'linear-gradient(135deg,#6366f1,#4f46e5)',
    'linear-gradient(135deg,#a855f7,#7c3aed)',
    'linear-gradient(135deg,#ec4899,#db2777)',
    'linear-gradient(135deg,#3b82f6,#2563eb)',
    'linear-gradient(135deg,#14b8a6,#0d9488)',
    'linear-gradient(135deg,#f59e0b,#d97706)',
    'linear-gradient(135deg,#ef4444,#dc2626)',
    'linear-gradient(135deg,#22c55e,#16a34a)',
  ];
  let h = 0;
  for (let i = 0; i < str.length; i++) h = (h * 31 + str.charCodeAt(i)) & 0xffffffff;
  return palette[Math.abs(h) % palette.length];
}

function escHtml(str = '') {
  return String(str).replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/"/g,'&quot;').replace(/'/g,'&#39;');
}

/* ── Spinner keyframe (injected) ── */
const spinStyle = document.createElement('style');
spinStyle.textContent = `
@keyframes spin { to { transform: rotate(360deg); } }
.spin { animation: spin .7s linear infinite; }
`;
document.head.appendChild(spinStyle);
