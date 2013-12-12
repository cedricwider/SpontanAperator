<%@ include file="/WEB-INF/pages/include.jsp" %>

<html>
<body>
	<h1>Profile</h1>
    <div>
        <div>Username:</div>
        <div>${userData.username}</div>
    </div>
    <div>
        <div>Nickname:</div>
        <div>${userData.nickname}</div>
    </div>
    <div>
        <div>Phone number:</div>
        <div>${userData.phoneNumber}</div>
    </div>
    <div>
        <div>Email:</div>
        <div>${userData.email}</div>
    </div>
</body>
</html>