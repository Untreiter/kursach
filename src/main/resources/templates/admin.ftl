<#import "parts/common.ftl" as c>
<#import "parts/footer.ftl" as f>

<@c.page "Admin">
    <div class="container">
    <div class="form-group">
        <form action="/admin" method="post" style="margin-top: 2%">
        <div><label> Логин :</label> <input type="text" class="form-control" name="username"/> </div>
        <div><label> Пароль:</label> <input type="password" class="form-control" name="password"/> </div>
        <div><input type="submit" class="btn btn-primary" value="Войти" style="margin-top: 2%;margin-bottom: 13%" /></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </form>
    </div>
    </div>
    <@f.footer />
</@c.page>