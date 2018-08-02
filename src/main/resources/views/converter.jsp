<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>自定义HttpMessageConverter</title>

</head>
<body>
    <div id="resp"></div>
    <input type="button" onclick="req();" value="请求"/>

<br/>
    <script type="text/javascript" src="/assets/js/jquery-1.7.2.js"> </script>
    <script type="text/javascript">
        function req() {
            alert("ok");
            $.ajax({
                url:"convert",
                type:"POST",
                data:"1-song",
                contentType:"application/x-wisely",
                success:function (data) {
                    $("#resp").html(data);
                }

            });

        }


    </script>

</body>
</html>