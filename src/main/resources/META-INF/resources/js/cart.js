
/**
 * 加入购物车
 */
function buy(bid){
	$.get("books_buy", {bid:bid}, function(data){
		if(data==="ok")
		{
			layer.msg("添加到购物车!", {time:800}, function(){
               location.reload();
            });
		}
		else if(data==="fail")
		{
            layer.msg("库存不足,请购买其他商品!", {time:800}, function(){

            });
		}else if(data === "notLogin"){
            location.href="../user_login.jsp";
        }
		/*if(data=="ok"){
			layer.msg("操作成功!", {time:800}, function(){
				location.reload();
			});
		}else if(data=="login"){
			alert("请登录后购买!");
			location.href="login.jsp";
		}else if(data=="empty"){
			alert("库存不足!");
			location.reload();
		}else{
			alert("请求失败!");
		}*/

	});
}

function lessen(bid){
    $.post("books_lessen", {bid:bid}, function(data){
        if(data==="ok"){
            layer.msg("操作成功!", {time:800}, function(){
                location.reload();
            });
        }
//		if(data=="ok"){
//			layer.msg("操作成功!", {time:800}, function(){
//				location.href="cart.action";
//			});
//		}else if(data=="login"){
//			alert("请登录后操作!");
//			location.href="login.jsp";
//		}else{
//			alert("请求失败!");
//		}
    });
}
/**
 * 购物车删除
 */
function deletes(bid){
    $.post("books_delete", {bid:bid}, function(data){
        if(data==="ok"){
            layer.msg("删除成功!", {time:800}, function(){
                location.reload();
            });
        }
    });
}