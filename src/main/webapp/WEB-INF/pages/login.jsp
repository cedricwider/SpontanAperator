<%@ include file="/WEB-INF/pages/include.jsp" %>

<html>
<body>
	<h1>Login</h1>
    <div>
       <form:form method="post" modelAttribute="loginUser" action="/spontan/login">
           <div>
               <label for="username">Username</label>
               <form:input path="username" name="username"/>
           </div>
           <div>
               <label for="password">Password</label>
               <form:password path="password" name="password"/>
           </div>
           <div>
               <input type="submit" value="Login"/>
           </div>
       </form:form>
    </div>
</body>
</html>