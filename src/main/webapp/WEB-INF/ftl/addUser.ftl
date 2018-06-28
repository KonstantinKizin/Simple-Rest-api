
<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html xmlns:form="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Tours</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-3 col-md-6 col-md-offset-3 col-lg-offset-0">
            <div class="well">
                <form class="form-horizontal" method="POST" action="add" >
                    <@spring.bind path="user"/>

                    <label><@spring.message"form.user.name"/></label>
                    <p><@spring.formInput  "user.name"/> </p>

                    <label><@spring.message"form.user.password"/></label>
                    <p><@spring.formInput "user.password"/> </p>

                    <label><@spring.message"form.user.email"/></label>
                    <p><@spring.formInput "user.email"/> </p>

                    <label><@spring.message"form.user.imageUrl"/></label>
                    <p><@spring.formInput "user.imageUrl"/> </p>

                    <p class="text-center"><input type="submit" value="submit"></p>
                </form>
            </div>
        </div>
    </div>

    <a href="?lang=ru">RU</a>
    <a href="?lang=en">EN</a>

</div>


</body>
</html>
