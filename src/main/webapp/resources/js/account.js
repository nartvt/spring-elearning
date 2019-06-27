$(function() {
	$('#frmLogin').submit(function() {
		console.log($(this).serialize());
		$.ajax({
			url : $(this).attr('action'),
			type : $(this).attr('method'),
			data : $(this).serialize(),
			success : function(res) {
				if (res) {
					// Trả về true => load lại trang
					location.reload();
				} else {
					swal({
						title : "Thông báo!",
						text : "Sai tên đăng nhập hoặc mật khẩu!",
						icon : "error",
						button : "Đóng",
					});
				}
			},
			error : function(err) {
				console.log(err);
			}
		});

		return false;
	});
});

// Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
$("#frmRegister").validate({
	rules : {
		fullname : {
			required : true,
			minlength : 4
		},
		email : {
			required : true,
			email : true
		},
		password : {
			required : true,
			minlength : 6
		},
		confirm : {
			equalTo : "#password"
		}
	},
	messages : {
		fullname : {
			required : "Vui lòng nhập họ tên!",
			minlength : "Họ tên ít nhất 4 ký tự!"
		},
		email : {
			required : "Vui lòng nhập email!",
			email : "Email không đúng định dạng!"
		},
		password : {
			required : 'Vui lòng nhập mật khẩu',
			minlength : 'Vui lòng nhập ít nhất 6 kí tự'
		},
		confirm : {
			equalTo : 'Mật khẩu nhập không khớp!'
		}
	}
});
