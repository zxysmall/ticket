$.validator.setDefaults({
	submitHandler : function(form) {
		 var serialStr = $('#commentForm').serialize();  
         var urlStr = form.action;  
         $.ajax({  
        	 url:urlStr,  
        	 dataType:'text',
        	 data:serialStr,  
             type:'post',  
             timeout:1000,
     		 async:false,
             success:function(data){  
                 if  (data ==1) {  
                	 $.confirm({
                    	 title: '成功提示!',
                    	    content: '操作成功!',
                    	    buttons: {
                    	        "确定": function () {
                    	        	window.location.reload();//刷新当前页面.
//                    	        	window.open("/ticket/allOrder");
                    	        }
                    	    }
                    	});
                 }else{  
                     $.alert({
                         title: '失败提示!',
                         content: '操作失败!info:【' + data + "】",
                         icon: 'fa fa-rocket',
                         animation: 'scale',
                         closeAnimation: 'scale',
                         buttons: {
                             okay: {
                                 text: '确定',
                                 btnClass: 'btn-blue'
                             }
                         }
                     });
                     return;  
                 }  
             }
         })
	}
});