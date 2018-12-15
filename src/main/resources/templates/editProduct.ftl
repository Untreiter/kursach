<#import "parts/common.ftl" as c>
<#import "parts/messages.ftl" as m>
<#import "parts/footer.ftl" as f>

<@c.page "Edit Product">
    <@m.show show messageType message />
    <div>
        <a href="/products">Назад</a>
    </div>
    <div class="container">
    <form method="post" action="/editProduct/${productEntity.id}" enctype="multipart/form-data">
    <div class="form-group">
        <input type="text" name="name" class="form-control" placeholder="Введите наименование:" value="${productEntity.name}">
        <input type="text" name="priceStr" class="form-control" placeholder="Введите цену за килограм:" value="${productEntity.price}">
        <textarea name="shortDescription" class="form-control" placeholder="Введите краткое описание:">${productEntity.shortDescription}</textarea>
        <br/>
            <b>Дополнительная информация:</b>
        <br/>
        <textarea name="description" class="form-control" placeholder="Ввелите полное описание:">${productData.description}</textarea>
        <#if productData.availability == 1>
            <label><input type="radio" name="availability"  value="0"/>Отсутствует</label><br/>
            <label><input type="radio" name="availability" value="1" checked/>Есть</label>
        <#else>
            <label><input type="radio" name="availability" value="0" checked/>Отсутствует</label><br/>
            <label><input type="radio" name="availability"  value="1" />Есть</label>
        </#if>
        <input type="text" name="quantityStr" class="form-control" value="${productData.quantity}">
        <img src="/img/${productImage}" class="rounded mx-auto d-block" alt="${productAltCode}"/>
        <input type="file" name="productImage" class="form-control" >
        <button type="submit" class="btn btn-primary" style="margin-top: 2%">Сохранить</button>
        <input type="hidden" name="_csrf" class="form-control" value="${_csrf.token}"/>
        <input type="hidden" name="id" class="form-control" value="${productEntity.id}"/>
    </div>
    </form>
    </div>
    <@f.footer />
</@c.page>
