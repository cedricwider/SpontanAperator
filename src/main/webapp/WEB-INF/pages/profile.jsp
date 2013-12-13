<%@ include file="/WEB-INF/pages/include.jsp" %>

<html>
<%@ include file="/WEB-INF/pages/header.html" %>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-2">
            <h2 class="form-signin-heading text-left">Profile</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="pull-left bg-white">
                <div class="row">
                    <div class="col-md-offset-1 col-md-11">Username: ${userData.username}</div>
                </div>
                <div class="row">
                    <div class="col-md-offset-1 col-md-11">Nickname: ${userData.nickname}</div>
                </div>
                <div class="row">
                    <div class="col-md-offset-1 col-md-11">Phone number: ${userData.phoneNumber}</div>
                </div>
                <div class="row">
                    <div class="col-md-offset-1 col-md-11">Email: ${userData.email}</div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>