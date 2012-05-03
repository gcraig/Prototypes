<!-- common functions :::
// written or changed by Vady.
// vady@i.com.ua

// 2use popup() function: <a href="javascript:;" onClick="javascript:popup('name', '#link', 0, 0, 300, 150, 0, 0, 1, 1, 1); return false;"></a>
function popup(name, url, left, top, width, height, toolbar, menubar, statusbar, scrollbar, resizable){
	var wint = (screen.height - height) / 2;
	var winl = (screen.width - width) / 2;
	toolbar_str = toolbar ? 'yes' : 'no';
	menubar_str = menubar ? 'yes' : 'no';
	statusbar_str = statusbar ? 'yes' : 'no';
	scrollbar_str = scrollbar ? 'yes' : 'no';
	resizable_str = resizable ? 'yes' : 'no';
	window.open(url, name, 'left='+winl+',top='+wint+',width='+width+',height='+height+',toolbar='+toolbar_str+',menubar='+menubar_str+',status='+statusbar_str+',scrollbars='+scrollbar_str+',resizable='+resizable_str);
}

function confirmation(){
ok=window.confirm('Are you sure that you want to delete checked fields?');
if(ok==true){document.forms.i_am_named_form_do_with_me_what_do_u_want.submit();}
}

function confirmA(){
ok=window.confirm('Are you sure that you want to delete this row?');
return ok;
}

function MM_swapImgRestore() { //v3.0
	var i,x,a=document.MM_sr;
	for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
	var d=document;
	if(d.images){ 
		if(!d.MM_p) d.MM_p=new Array();
		var i,j=d.MM_p.length,a=MM_preloadImages.arguments;
		for(i=0; i<a.length; i++)
		if (a[i].indexOf("#")!=0){
		d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];
		}
	}
}

function MM_findObj(n, d) { //v4.01
	var p,i,x;
	if(!d) d=document;
	if((p=n.indexOf("?"))>0&&parent.frames.length) {
		d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);
	}
	if(!(x=d[n])&&d.all) x=d.all[n];
	for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
	for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
	if(!x && d.getElementById) x=d.getElementById(n);
	return x;
}

function MM_swapImage() { //v3.0
	var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
	if ((x=MM_findObj(a[i]))!=null){
		document.MM_sr[j++]=x;
		if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];
	}
}

function TboxOver(b) { //v2.5
	var c;
	if(document.getElementById) {
		c = b.parentNode.parentNode.parentNode.parentNode;
		c.className = 'tbox-tab-over';
	//	document.getElementById('tbox1').className = "tbox-tab-over";
	}
}

function TboxOut(b) { //v2.5
	var c;
	if(document.getElementById) {
		c = b.parentNode.parentNode.parentNode.parentNode;
		c.className = 'tbox-tab';
	//	document.getElementById(b).className = "tbox-tab";
	}
}

function ov() {
	this.defaultclassName = this.className;
	this.className = 'iselected';
}

function ou(){	
	if(this.defaultclassName) {
		this.className = this.defaultclassName;
	} else {
		this.className = '';
	}
}

function tableruler()
{
	if (document.getElementById && document.createTextNode)
	{
		var tables=document.getElementsByTagName('table');
		for (var i=0;i<tables.length;i++)
		{
			if(tables[i].className=='data')
			{
				var trsaved = new Array();
				var trs=tables[i].getElementsByTagName('tr');
				for(var j=0;j<trs.length;j++)
				{
					if(trs[j].parentNode.nodeName=='TBODY')
					{
						trsaved[j] = trs[j].className;
//						trs[j].attachEvent('onmouseover',ov);
//						trs[j].attachEvent('onmouseout',ou);
						trs[j].onmouseover=ov;
						trs[j].onmouseout=ou;
					}
				}
			}
		}
	}
}

function mOvr(src) {
	if(document.getElementById) {
		if (!src.contains(event.fromElement)) {
			src.style.cursor = 'hand';
			src.parentNode.parentNode.parentNode.className = 'tbox-tab-over';
		}
	}	
}

function mOut(src) {
	if(document.getElementById) {
		if (!src.contains(event.toElement)) {
			src.style.cursor = 'default';
			src.parentNode.parentNode.parentNode.className = 'tbox-tab';
		}
	}
}

function mClk(src) {
	if (event.srcElement.tagName == 'TD') {
		src.children.tags('A')[0].click();
	}
}

function CheckAll(frm, mark){
	for (i = 0; i <= frm.elements.length; i++) {
		try {
			frm.elements[i].checked = mark;
		}
		catch(er) {
		}
	}
}


// -->