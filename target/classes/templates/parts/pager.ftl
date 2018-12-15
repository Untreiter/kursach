<#macro pager url page>
    <div class="container" style="margin-top: 12px; margin-bottom: 12px">


        <h5><a href="#">Страницы: </a></h5>

    <#list 1..page.getTotalPages() as p>
        <#if (p - 1) == page.getNumber()>

            <span>${p}</span>

        <#else>

            <a href="${url}?page=${p - 1}">${p}</a>

        </#if>
    </#list>

    </div>
</#macro>