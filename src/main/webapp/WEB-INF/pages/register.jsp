<%@ include file="/WEB-INF/pages/include.jsp" %>
<html>
    <%@ include file="/WEB-INF/pages/header.html" %>
    <body>
        <div class="container">
           <form:form cssClass="form-signin" method="post" modelAttribute="newUser" action="/spontan/user/new">
               <h2 class="form-signin-heading">Please Register</h2>
               <form:input cssClass="form-control top-radius" path="username" name="username" placeholder="Username"/>
               <form:password cssClass="form-control no-radius" path="password" name="password" placeholder="Password"/>
               <form:password cssClass="form-control no-radius" path="passwordConfirmation" name="passwordConfirmation" placeholder="Confirm password"/>
               <form:input cssClass="form-control no-radius" path="nickname" name="nickname" placeholder="Nickname"/>
               <form:input cssClass="form-control no-radius" path="phonenumber" name="phoneNumber" placeholder="Phone number"/>
               <form:input cssClass="form-control bottom-radius" path="email" name="email" placeholder="Email address"/>
               <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login"/>
           </form:form>
        </div>
    </body>
</html>