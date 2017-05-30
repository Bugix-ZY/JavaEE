	function goPage(pno, psize, total){
	    var itable = document.getElementById("logs");
	    console.log(total);
	    var totalPage = 0;//总页数
	    var pageSize = psize;//每页显示行数
	    //总共分几页 
	    if(total / pageSize > parseInt(total / pageSize)){   
	        totalPage = parseInt(total / pageSize) + 1;   
	    } else {   
	    	totalPage = parseInt(total / pageSize);   
	    }   
	    var currentPage = pno;//当前页数
	    var startRow = 0;
	    var endRow = 0;

	    startRow = (currentPage - 1) * pageSize + 1;
	    endRow = currentPage * pageSize;

	    endRow = (endRow > total)? total: endRow;    
	    console.log(endRow);
	    //遍历显示数据实现分页
	    for(var i = 1;i <= total ;i++){    
	        var irow = itable.rows[i - 1];
	        if(i >= startRow && i <= endRow ){
	            irow.style.display = "inline";    
	        }else{
	            irow.style.display = "none";
	        }
	    }
	    var tempStr = "共"+total+"条记录 分"+totalPage+"页 当前第"+currentPage+"页 ";
	    if(currentPage>1){
	        tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+", "+total+")\">首页</a>";
	        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+","+total+")\"><上一页</a>"
	    }else{
	        tempStr += "首页";
	        tempStr += " <上一页";    
	    }

	    if(currentPage<totalPage){
	        tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+","+total+")\">下一页></a>";
	        tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+", "+total+")\">尾页</a>";
	    }else{
	        tempStr += " 下一页>";
	        tempStr += " 尾页";    
	    }

	    document.getElementById("barcon").innerHTML = tempStr;
	}