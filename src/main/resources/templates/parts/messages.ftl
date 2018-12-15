<#macro show show=false type=0 message="">
    <div>
    <#if show == true>
        <#if type = 0>
            <p>${message}</p>
        <#else>
            <p>${message}</p>
        </#if>
    </#if>
    </div>
</#macro>