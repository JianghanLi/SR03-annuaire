/**
 * ActionService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package action;

public interface ActionService extends javax.xml.rpc.Service {
    public java.lang.String getActionAddress();

    public action.Action getAction() throws javax.xml.rpc.ServiceException;

    public action.Action getAction(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
