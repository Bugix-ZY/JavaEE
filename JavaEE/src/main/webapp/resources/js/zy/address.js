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


function setDefault(addressid) {
	var springUrl = $("#hiddenSpringUrl").val();
	$.ajax({
		url : springUrl + "/user/address/setdefault",
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


function getCity()
{
	var provinceid = document.getElementById("province").value;
	var url = document.getElementById("regionurl").value;
	$.post(url, {region_id:provinceid},function(result){
      document.getElementById("city").options.length=0;
      document.getElementById("district").options.length=0;  		
  	for (var i = 0; i < result.length; i++) {
          $("#city").append("<option value=" + result[i].region_id +">" + result[i].region_name + "</option>");
      }
	});
}
function getDistrict()
{
	var cityid = document.getElementById("city").value;
	var url = document.getElementById("regionurl").value;
	$.post(url, {region_id:cityid},function(result){
		document.getElementById("district").options.length=0;
  	for (var i = 0; i < result.length; i++) {
          $("#district").append("<option value=" + result[i].region_id +">" + result[i].region_name + "</option>");
      }
	});
}

//function convert()
//{ 
//	var pro = document.getElementById("province");
//	var index  = pro.selectedIndex;
//	var proname = pro.options[index].text;
//	document.getElementById("provincename").value = proname;
//}
