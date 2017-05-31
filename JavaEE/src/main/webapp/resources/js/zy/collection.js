function addCollection() {
	var springUrl = $("#hiddenSpringUrl").val();
	console.log(document.getElementById("isCollection").src);
	if (document.getElementById("isCollection").src == "http://localhost:8080/JavaEE/resources/images/zjh/goodsDetail-footer-3.png") {
		document.getElementById("isCollection").src = "/JavaEE/resources/images/zy/red_heart.png";
			$.ajax({
				url : springUrl + "/user/collection/add",
				async : false,
				cache : false,
				type : 'post',
				dataType : "json",
				data : {
					goodsId : $("#hiddenGoodsId").val(),
				},
				success : function(data) {
					if (data.code == "200") {
						location.reload();
					}
				}
			});
	}
	else if (document.getElementById("isCollection").src == "http://localhost:8080/JavaEE/resources/images/zy/red_heart.png") {
		document.getElementById("isCollection").src = "/JavaEE/resources/images/zjh/goodsDetail-footer-3.png";
				$.ajax({
					url : springUrl + "/user/collection/delete",
					async : false,
					cache : false,
					type : 'post',
					dataType : "json",
					data : {
						goodsId : $("#hiddenGoodsId").val(),
					},
					success : function(data) {
						if (data.code == "200") {
							location.reload();
						}
					}
				});
		}
}

function deleteCollection(goodsId) {
	var springUrl = $("#hiddenSpringUrl").val();
	$.ajax({
		url : springUrl + "/user/collection/delete",
		async : false,
		cache : false,
		type : 'post',
		dataType : "json",
		data : {
			goodsId : goodsId
		},
		success : function(data) {

		}
	});
	window.location.reload();
}

	

