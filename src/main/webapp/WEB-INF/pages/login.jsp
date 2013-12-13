<%@ include file="/WEB-INF/pages/include.jsp" %>
<html>
    <%@ include file="/WEB-INF/pages/header.html" %>
    <body>
        <div class="container">
           <form:form cssClass="form-signin" method="post" modelAttribute="loginUser" action="/spontan/user/login">
               <h2 class="form-signin-heading">Please sign in</h2>
               <form:input cssClass="form-control top-radius" path="username" name="username" placeholder="Username"/>
               <form:password cssClass="form-control bottom-radius" path="password" name="password" placeholer="Password"/>
               <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login"/>
               <div class="text-info">No registered user yet? <a href="/spontan/user/new">Register here...!</a></div>
           </form:form>
        </div>
    </body>
</html>