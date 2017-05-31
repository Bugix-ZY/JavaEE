function deleteAddress(addressid) {
	var springUrl = $("#hiddenSpringUrl").val();
	$.ajax({
		url : springUrl + "/user/address/delete",
		async : false,
		cache : false,
		type : 'post',
		dataType : "json",
		data : {
			addressid : addressid
		},
		success : function(data) {

		}
	});
	window.location.reload();
}
