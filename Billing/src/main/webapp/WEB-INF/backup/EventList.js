function open_form(file_name)
{
	var vals = new Array();
	vals = window.showModalDialog(file_name);
	if (vals != null)
		return true;
	else 
		return false;
}


function check_contact()
{
	for (k in elements.tags('options'))
	{
		alert(k);
	}
//	alert(frm.event_contact_list.);
}

function return_to_main()
{
//	opener.focus();
//	opener.reload;
	opener.location.reload();
	window.close();


}
