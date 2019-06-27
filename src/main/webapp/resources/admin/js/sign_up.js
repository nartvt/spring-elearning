$(function () {
  $('#btnSignUp').on(
    'click',
    function () {
      var url = $(this).data('id');
      $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function (res) {
          var html = '';
          for (var i = 0; i < res.length; i++) {
            html += '<option value="' + res[i].id + '"'
              + res[i].description + '</option>';
          }
          $('#roleId').html(html);
          $('#registerModal').modal('show');
        },
        error: function (err) {
          console.log(err);
        }
      });
    });

  $('#frmRegister').submit(function () {
    var user = {
      email: $('#email').val(),
      fullname: $('#fullname').val(),
      password: $('#password').val(),
      confirm: $('#confirm').val(),
      roleId: $('#roleId').val(),
    }
    $.ajax({
      data: JSON.stringify(user),
      type: $(this).attr('method'),
      url: $(this).attr('action'),
      dataType: 'json',
      contentType: 'application/json',
      success: function (res) {
        if (res.success == 'true') {
          alert(res.message);
          $('#registerModal').modal('hide');
        } else {
          alert(res.message);
        }
      },
      error: function (err) {
        console.log(err);
      }
    });
  });
});