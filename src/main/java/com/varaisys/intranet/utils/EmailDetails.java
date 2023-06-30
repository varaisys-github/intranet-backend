package com.varaisys.intranet.utils;

/**
 * @Author Babli Singh
 * @CreationDate - 7-02-2023
 * @ModifyDate - 7-02-2023
 * @Desc
 */

public class EmailDetails {

	private String recipient;
	private String msgBody;
	private String subject;
	private String attachment;
	
	
	
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public EmailDetails() {
		super();
	}

}
