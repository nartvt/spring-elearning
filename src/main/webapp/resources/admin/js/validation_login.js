/**
 * 
 */
$(function () {
  $('#frmLogin').submit(function () {
    $.ajax({
      data: $(this).serialize(),
      type: $(this).attr('method'),
      url: $(this).attr('action'),
      success: function (res) {
        console.log(res)
        if (res) {
          location.reload();
        } else {
          swal({
            title: "Thong Bao !",
            text: "Sai ten Dang Nhap Hoac Mat Khau",
            icon: "error",
            button: "Close",
          });
        }
      },
      error: function (error) {
        console.log(err)
      }
    });
    return false;
  });
});
