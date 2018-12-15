<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<#import "parts/messages.ftl" as m>
<#import "parts/footer.ftl" as f>

<@c.page "Products">
    <@m.show show messageType message />
    <div class="container" style="margin-top: 2%; margin-bottom: 2%">
    <div class="row">
    <div class="col-3">
    <form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Выйти"/>
    </form>
    </div>
    <div class="col-3">
        <form action="/" method="get">
            <input type="submit" value="К каталогу"/>
        </form>
    </div>
    <div class="col-3">
        <a href="/addProduct">Добавить новый продукт</a>
    </div>
    <div class="col-3">
    <form method="post" action="/deleteProducts">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Удалить</button>
    </div>
    </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th></th>
            <th><b>Изображение</b></th>
            <th><b>ID</b></th>
            <th><b>Наименование</b></th>
            <th><b>Цена р./кг</b></th>
            <th><b>Краткое описание</b></th>
            <th><b>Действие</b></th>
        </tr>
        </thead>
            <tbody>
            <#list productEntities.content as productEntity>
                <tr>
                <td><input type="checkbox" name="id_${productEntity.id}" multiple value="${productEntity.id}"></td>
                <#list productMedia as media>
                    <#if media.getProductId() == productEntity.getId()>
                        <td><img src="img/${media.getImgPath()}" alt="${media.getAltCode()}" width="100" height="100"/></td>
                        <#break/>
                    <#elseif !media_has_next>
                        <td><img src="/img/ivcon_logo_new_180.jpg" width="100" height="100"/> </td>
                    </#if>
                </#list>
                <td>${productEntity.id}</td>
                <td>${productEntity.name}</td>
                <td>${productEntity.price}</td>
                <td>${productEntity.shortDescription}</td>
                <td><a href="/editProduct/${productEntity.id}">Изменение</a></td>
                </tr>
            <#else>
                Нет продуктов
            </#list>
            </tbody>
    </table>
<input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
    <@p.pager url, productEntities/>
    <@f.footer />
</@c.page>