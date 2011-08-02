<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title></title>
<link href="${skinPath}/css/create_document.css" rel="stylesheet" type="text/css">
</head>
<body>
<form class="createDocument" action="${This.path}/createDocument" method="post" enctype="multipart/form-data" target="hiddenIFrame">
<h3>Ajouter un ${docType.label} dans ${currentDoc.title} </h3>
<div class="center">
<table class="create">
<tr>
<td>Titre</td>
<td><input class="border input" type="text" name="dc:title" /></td>
</tr>
<tr>
<td>Description</td>
<td><textarea class="border input" name="dc:description" rows="2"></textarea></td>
</tr>
<#if coreType.hasSchema("note")>
<tr>
<td>Content</td>
<td><textarea class="border input" name="note:note" rows="5"></textarea></td>
</tr>
</#if>
<#if coreType.hasSchema("file")>
<tr>
<td>Content</td>
<td><input class="border input" name="file:content" type="file"></td>
</tr>
</#if>
</table>
<div class="actions">
<input class="border" type="submit" name="createDocument" value="Créer"/>
<button class="border" name="cancel" value="Cancel" type="button" onclick="parent.jQuery.fancybox.close()">Annuler</button>
<input type="hidden" name="docRef" value="${currentDoc.id}" />
<input type="hidden" name="doctype" value="${docType.id}" />
</div>
</div>
</form>
<iframe onload="parent.iframeLoaded(this)" style="visibility:hidden;display:none" name="hiddenIFrame"/>
</body>
</html>
