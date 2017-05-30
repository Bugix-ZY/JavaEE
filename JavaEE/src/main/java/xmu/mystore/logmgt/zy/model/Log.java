package xmu.mystore.logmgt.zy.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * @Description: 日志实体类
 * @ClassNmae: Log
 * @author ZhengYang
 * @version: [1.0]
 */

@Component
public class Log implements Serializable{

	/*-- Field --*/
	private static final long serialVersionUID = 98264L;
	/* Log ID */
	private long log_id;
	/* 操作者 ID */
	@NotNull
	private int admin_id;
	/* 操作时间 */
	@NotNull
	private long op_time;
	/* 操作对象(类) */
	@NotNull
	private String op_object;
	/* 操作方法 */
	@NotNull
	private String op_method;
	/* 操作内容(参数) */
	@NotNull
	private String op_content;
	/* 操作结果（成功／失败） 0-失败 1-成功*/
	private int result;
	/* 操作者的 IP 地址 */
	private String ip_address;
	

	/*-- Getters --*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public long getOp_time() {
		return op_time;
	}
	public String getOp_object() {
		return op_object;
	}
	public String getOp_content() {
		return op_content;
	}
	public int getResult() {
		return result;
	}
	public String getIp_address() {
		return ip_address;
	}
	public String getOp_method() {
		return op_method;
	}
	@Override
	public String toString() {
		return "Log [admin_id=" + admin_id + ", op_time=" + op_time + ", op_object=" + op_object + ", op_content="
				+ op_content + ", result=" + result + ", ip_address=" + ip_address + "]";
	}
	
	public Log(){
	}
	
	public Log(int admin_id, long op_time, String op_object, String op_method, String op_content, int result, String ip_address) {
		super();
		this.admin_id = admin_id;
		this.op_time = op_time;
		this.op_object = op_object;
		this.op_method = op_method;
		this.op_content = op_content;
		this.result = result;
		this.ip_address = ip_address;
	}
	
	
	

}
