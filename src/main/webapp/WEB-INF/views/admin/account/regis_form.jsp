<c:url value="/auth/register" var="register" />
<form action="${register}" method="post" id="frmRegister">
  <div class="form-group">
    <label for="fullname">Ho Ten</label>
    <input type="text" class="form-control" name="fullname" id="fullname">
  </div>
  <div class="form-group">
    <label for="email">Email:</label>
    <input type="text" class="form-control" name="email" id="email">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" name="password" id="password">
  </div>
  <div class="form-group">
    <label for="password">Nhap Lai Mat Khau:</label>
    <input type="password" class="form-control" name="confirm" id="confirm">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>