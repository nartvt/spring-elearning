/**
 * 
 */
$('#frmLogin').submit(function(){
  $.ajax({
    data:$(this).serialize(),
    type:$(this).attr('method'),
    url: $(this).attr('action'),
    success: function(res){
      console.log(res)
      if(res){
        location.reload();
      }
      else{
        alert('Sai Email Hoac mat khau');
      }
    },
    error: function(error){
      console.log(err)
    }
  });
  return false;
});