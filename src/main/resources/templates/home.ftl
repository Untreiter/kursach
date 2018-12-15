<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<#import "parts/messages.ftl" as m>
<#import "parts/footer.ftl" as f>
<#import "parts/header.ftl" as h>

<@c.page "Catalog">
    <@h.header/>
    <@m.show show messageType message />
    <div class="container-fluid bg-warning" style="margin-bottom: 20px">

    <form method="get" action="/catalog">
        <span ><b>Фильтры: </b></span>
        <span class="filter">Наименование: </span><input type="text" name="nameFilter" value="${nameFilter}">
        <span>Цена: c </span><input type="text" name="fromFilter" value="${fromFilter}">
        <span>до </span><input type="text" name="toFilter" value="${toFilter}">
        <span>Упорядочить по: </span>
        <select name="order">
            <option value="" <#if order == 0>selected</#if>></option>
            <option value="price" <#if order == 2>selected</#if>>Цена</option>
            <option value="name" <#if order == 1>selected</#if>>Наименование</option>
          </select>
         <button type="submit">Найти</button>
     </form>
    </div>
    <div class="container">
    <div class="row justify-content-center">
    <#list productEntities.content as productEntity>
        <div class="col-sm-6  text-center">

                 <#list productMedia as media>
                    <#if media.getProductId() == productEntity.getId()>
                        <a href="/view/${productEntity.id}"><img src="img/${media.getImgPath()}" class="img-responsive" alt="${media.getAltCode()}"/></a>
                     <#break/>
                    <#elseif !media_has_next>
                         <a href="/view/${productEntity.id}"><img src="/img/placeholder.jpg" class="img-responsive" /></a>
                    </#if>
                 </#list>
                <h3><a href="/view/${productEntity.id}">${productEntity.name}</a></h3>
                <h4>${productEntity.price} р.</h4>
                <h5>${productEntity.shortDescription}</h5>
        </div>
    </#list>
    </div>
    </div>
    <@p.pager "", productEntities />
    <@f.footer />
</@c.page>
