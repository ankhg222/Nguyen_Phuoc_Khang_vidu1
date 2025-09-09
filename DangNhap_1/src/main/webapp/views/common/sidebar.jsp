<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div class="sidebar" id="adminSidebar">
  <ul class="menu">
    <li><a href="${ctx}/admin/dashboard"><i class="fa fa-tachometer-alt"></i> Dashboard</a></li>
    <li class="has-sub">
      <button type="button" class="toggle"><i class="fa fa-folder"></i> Quản lý Danh mục</button>
      <ul class="submenu">
        <li><a href="${ctx}/admin/category/add">Thêm danh mục mới</a></li>
        <li><a href="${ctx}/admin/category/list">Danh sách danh mục</a></li>
      </ul>
    </li>
    <li><a href="${ctx}/admin/product/list"><i class="fa fa-cube"></i> Quản lý sản phẩm</a></li>
    <li><a href="${ctx}/logout"><i class="fa fa-sign-out-alt"></i> Đăng xuất</a></li>
  </ul>
</div>

<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
.sidebar{width:220px;background:#1e90ff;color:#fff;min-height:100vh;padding-top:20px}
.sidebar .menu{list-style:none;margin:0;padding:0}
.sidebar a,.sidebar .toggle{display:block;color:#fff;text-decoration:none;padding:10px 16px;border:none;background:none;width:100%;text-align:left;cursor:pointer}
.sidebar a:hover,.sidebar .toggle:hover{background:#1976d2}
.submenu{display:none;list-style:none;padding-left:20px}
.has-sub.open .submenu{display:block}
</style>

<script>
document.querySelectorAll('#adminSidebar .has-sub > .toggle').forEach(btn=>{
  btn.addEventListener('click',()=>btn.parentElement.classList.toggle('open'));
});
</script>
