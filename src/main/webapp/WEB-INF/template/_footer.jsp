<%--<script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.slim.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/sidebars.js"></script>
<%--<script> alert("ALERT!!! Use Mozilla Firefox or Google Chrome")</script>--%>
<script>let msg = '${errors}';
    if(msg != '') {
        alert('${errors}');
    }</script>
<%--<div class="text-center fixed-bottom">--%>
<%--    <p class=""><b>${footer}</b></p>--%>
<%--</div>--%>