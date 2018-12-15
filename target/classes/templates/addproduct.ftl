<#import "parts/common.ftl" as c>
<#import "parts/messages.ftl" as m>
<#import "parts/footer.ftl" as f>

<@c.page "Add Product">
    <@m.show show messageType message />
    <div>
        <a href="/products">Назад</a>
    </div>
    <div class="container">
    <form method="post" enctype="multipart/form-data">
    <div class="form-group">
        <input type="text" class="form-control"  name="name" placeholder="Введите наименование:">
        <input type="text" class="form-control" name="priceStr" placeholder="Введите цену за килограм:">
        <textarea name="shortDescription" class="form-control" placeholder="Введите краткое описание:"></textarea>
        <br/>
        <b>Дополнительная информация:</b>
        <br/>
        <textarea name="description" class="form-control" placeholder="Введитеполное описание:"></textarea>
        <select name="availability" class="form-control" >
            <option value="0">Отсутствует</option>
            <option value="1">Есть</option>
        </select>
        <input type="text" class="form-control" name="quantityStr" placeholder="Количество">
        <input type="file" class="form-control" name="productImage" >
        <button type="submit" class="btn btn-primary" style="margin-top: 2%">Добавить продукт</button>
        <input type="hidden" class="form-control" name="_csrf" value="${_csrf.token}"/>
    </div>
    </form>
    </div>
    <@f.footer />
</@c.page>
