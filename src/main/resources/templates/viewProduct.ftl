<#import "parts/common.ftl" as c>
<#import "parts/footer.ftl" as f>

<@c.page "${productEntity.name}">

    <div>
        <a href="/catalog">Назад</a>
    </div>
    <div class="container-fluid">
    <div class="row">

    <div class="col-6">
<img src="/img/${productImage}" class="rounded mx-auto d-block" alt="${productAltCode}" style="height: 100%"/>
    </div>
    <div class="col-6">
    <div>
    <p><b>${productEntity.name}</b></p>
    </div>
    <div>
    <p><span>Цена: </span>${productEntity.price}р./кг</p>
    </div>
<p><b>Дополниительная информация:</b></p>
    <div>
    <p>${productData.description}</p>
    </div>
    <div>
    <#if productData.availability == 1>
        <p>Есть на складе</p>
        <p><span>Количество: </span>${productData.quantity}</p>
    <#else>
        <p>Отсутствует</p>
    </#if>
    </div>
    </div>
    </div>
    </div>
    <div class="container" style="margin-bottom: 10%">
    <div class="row">
        <div class="col-2">
            <h5><a href="/view/${links.prevProduct}" class="text-left">Предыдущий</a></h5>
        </div>
        <div class="col-8"></div>
        <div class="col-2">
            <h5><a href="/view/${links.nextProduct}" class="text-right">Следующий</a></h5>
        </div>
    </div>
    </div>
    <@f.footer />
</@c.page>
