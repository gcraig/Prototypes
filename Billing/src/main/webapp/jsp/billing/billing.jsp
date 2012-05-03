<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>

<!-- page title -->
<h1>
	Billing Overview
</h1>

<!-- breadcrumbs -->
<font color="#999999">
<b>Location: <a href="Billing.do">Billing</a></b>
</font>

<br>
<br>

<table border=0 cellpadding=0 cellspacing=0 width=100%>

<tr>
	<td width="50%">
	<center>
		<applet code=com.objectplanet.chart.ChartApplet archive=chart.jar width=300 height=200>
		<param name=chart value=pie>
		<param name=sampleValues value="643,557,825,829,376">
		<param name=sampleLabels value="Paid\n,Past 30\n,Past 60\n,Past 90\n,Current\n">
		<param name=sampleLabelsOn value=true>
		<param name=sampleLabelStyle value=outside>
		<param name=percentLabelsOn value=true>
		<param name=percentLabelStyle value=outside>
		<param name=outsideLabelFont value="Arial,bold,11">
		<param name=sampleColors value="#66aa66,#cc8888,#cc6666,#cc4444,#8888cc">
		<param name=sliceSeperatorColor value=white>
		<param name=selectionStyle value=detached>
		<param name=3dModeOn value=true>
		<param name=depth value=0.12>
		<param name=angle value=35>
		<param name="charttitle" value="Paid/Unpaid Invoices">
		<param name=pieRotationOn value=true>
		<param name=background value=#EDEEAC>
		</applet>	
		</center>
	</td>
	<td>
<!-- 		<applet code=com.objectplanet.chart.ChartApplet archive=chart.jar width=300 height=200>
		<param name=chart value="bar">
		<param name=sampleValues value="10,20,40,65,50">
		<param name=sampleColors value="#FF7310">
		<param name="charttitle" value="12 Month Revenue">
		<param name=range value=70>
		<param name=background value=#FFFFCC>
		</applet> -->
		<applet code=com.objectplanet.chart.ChartApplet archive=chart.jar width=300 height=200>
		<param name=chart value="bar">
		<param name=sampleValues value="10,20,30,40,50">
		<param name=sampleColors value="#0587D9">
		<param name=background value=#EDEEAC>
		<param name=3dModeOn value="true">
		<param name=3ddepth value="5">
		<param name=barWidth value="0.6">
		<param name=barOutlineOff value="true">
		<param name=rangeLabelsOff value="true">
		<param name="charttitle" value="Monthly Revenue">
		</applet>
	</td>
</tr>
</table>

<br>

<h1>
Action Items
</h1>

<table width="100%" align="center" id="row">
<thead>
<tr>
<th>Date</th>
<th>Scheduled Automated Task</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><img src="images/alarm_16.gif">&nbsp;&nbsp;2005-08-19 7:00am</td>
<td>Batch Invoice Processing - Month of December</td>
</tr>
<tr class="even">
<td><img src="images/alarm_16.gif">&nbsp;&nbsp;2005-08-20 3:00am</td>
<td>System maintenance - Archival and Exception reporting</td>
</tr>
</tbody>
</table>

<br>

<h1>
Messages
</h1>

<table width="100%" align="center" id="row">
	<thead>
		<tr>
		<th>Description</th>
		</tr>
	</thead>
	<tbody>
		<tr class="odd">
		<td><a href=""><img src="images/flag_16.gif"></a>&nbsp;&nbsp;<a href="">You have 32 unapproved invoices to review</a></td>
		</tr>
		<tr class="even">
		<td><a href=""><img src="images/mail_content_16.gif"></a>&nbsp;&nbsp;<a href="">You have 12 personal messages to review</a></td>
		</tr>
	</tbody>
</table>
