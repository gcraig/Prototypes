<%@ taglib uri='/WEB-INF/template.tld' prefix='template' %> 
<template:insert template='/templates/mainLayout.jsp'> 
  <template:put name='title' content='Administration' direct='true'/> 
  <template:put name='breadcrumb' content='Admin > Overview' direct='true'/> 
  <template:put name='menutab' content='/common/view/menutab.jsp' />
  <template:put name='menu' content='/common/view/clientmenu.jsp' />
  <template:put name='info' content='/common/view/info.jsp' />
  <template:put name='header' content='/common/view/header.jsp' /> 
  <template:put name='content' content='/content/admin.jsp'/>
  <template:put name='pageFooter' content='/common/view/pageFooter.jsp' />   
  <template:put name='footer' content='/common/view/footer.jsp' /> 
</template:insert>