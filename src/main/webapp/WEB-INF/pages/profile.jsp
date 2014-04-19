<%@ include file="/WEB-INF/pages/include.jsp" %>
<html>
<%@ include file="/WEB-INF/pages/header.html" %>
    <body>
        <div class="container">
            <div class="jumbotron bg-white">
                <h2>${userData.firstname}&nbsp;(${userData.nickname})&nbsp;${userData.lastname}</h2>
                <small>
                    <div class="row">
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-envelope"> ${userData.email}</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-earphone"> ${userData.phoneNumber}</span>
                        </div>
                    </div>
                </small>
            </div>

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Upcoming Events</h4>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-11">
                                    <em>09.04.2015</em> My Birthday...!
                                </div>
                            </div>
                        </div>
                    </div>
            <div class="row top-buffer">
                <div class="col-lg-12">
                    <div class="row">
                        <div class=" col-md-5">
                            <div id="my_events" class="panel panel-info">
                                <div class="panel-heading">
                                    <h4>My Events</h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-offset-2 col-md-5">
                            <div id="usersList" class="panel panel-info">
                                <div class="panel-heading">
                                    <h4>My Friends</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    <script>
        $(function () {
            app.initialize();
            app.start();
            app.index();
        });
    </script>
    </body>
</html>