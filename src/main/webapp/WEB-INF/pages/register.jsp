<%@ include file="/WEB-INF/pages/include.jsp" %>

<html>
<body>
	<h1>Register</h1>
    <div>
       <form:form method="post" modelAttribute="newUser" action="/spontan/user/new">
           <div>
               <label for="username">Username</label>
               <form:input path="username" name="username"/>
           </div>
           <div>
               <label for="password">Password</label>
               <form:password path="password" name="password"/>
           </div>
           <div>
               <label for="passwordConfirmation">PasswordConfirmation</label>
               <form:password path="passwordConfirmation" name="passwordConfirmation"/>
           </div>
           <div>
               <label for="nickname">Nickname</label>
               <form:input path="nickname" name="nickname"/>
           </div>
           <div>
               <label for="phoneNumber">PhoneNumber</label>
               <form:input path="phonenumber" name="phoneNumber"/>
           </div>
           <div>
               <label for="email">Email</label>
               <form:input path="email" name="email"/>
           </div>
           <div>
               <input type="submit" value="Login"/>
           </div>
       </form:form>
    </div>
</body>
</html>