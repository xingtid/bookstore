$(function() {
	$(".meun-item").click(function() {
		$(".meun-item").removeClass("meun-item-active");
		$(this).addClass("meun-item-active");
		// var itmeObj = $(".meun-item").find("img");
		// itmeObj.each(function() {
		// var items = $(this).attr("src");
		// items = items.replace("_grey.png", ".png");
		// items = items.replace(".png", "_grey.png")
		// $(this).attr("src", items);
		// });
		// var attrObj = $(this).find("img").attr("src");
		// ;
		// attrObj = attrObj.replace("_grey.png", ".png");
		// $(this).find("img").attr("src", attrObj);
	});
	$("#topAD").click(function() {
		$("#topA").toggleClass(" glyphicon-triangle-right");
		$("#topA").toggleClass(" glyphicon-triangle-bottom");
	});
	$("#topBD").click(function() {
		$("#topB").toggleClass(" glyphicon-triangle-right");
		$("#topB").toggleClass(" glyphicon-triangle-bottom");
	});
	$("#topCD").click(function() {
		$("#topC").toggleClass(" glyphicon-triangle-right");
		$("#topC").toggleClass(" glyphicon-triangle-bottom");
	});
	$(".toggle-btn").click(function() {
		$("#leftMeun").toggleClass("show");
		$("#rightContent").toggleClass("pd0px");
	})

});
function updater(date) {
	var id = $(date).attr("id");
	var state = $(date).attr("data-state");
	var price = $(date).attr("data-price");
	var vprice = $(date).attr("data-vprice");
	var type = $(date).attr("data-type");
	var mark = $(date).attr("data-mark");
	switch (type) {
	case 1:
		$("#rtypeup").find('option').eq(0).attr('selected', 'selected');// 类型

		break;
	case 2:
		$("#rtypeup").find('option').eq(1).attr('selected', 'selected');// 类型

		break;

	default:
		break;
	}

	if (state == 1) {
		$("#rstate1").attr("checked", "checked");
	} else if (state == 0) {
		$("#rstate2").attr("checked", "checked");
	}
	$("#rpriceup").val(price);// V价格
	$("#rvpriceup").val(vprice);// 状态
	$("#rMarkup").val(mark);// 备注
	$("#rsup").val(id);
}

function deletea(date) {
	var id = $(date).attr("id");
	$("#dele").val(id);
}

function updateType(date) {
	var id = $(date).attr("id");
	var name = $(date).attr("data-name");
	var mark = $(date).attr("data-mark");

	$("#uu_name").val(name);
	$("#uu_mark").val(mark);
	$("#rsup").val(id);
}
