/**
 * ActionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package action;

public class ActionServiceLocator extends org.apache.axis.client.Service implements action.ActionService {

    public ActionServiceLocator() {
    }


    public ActionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ActionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Action
    private java.lang.String Action_address = "http://localhost:8080/SR03-annulaire/services/Action";

    public java.lang.String getActionAddress() {
        return Action_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ActionWSDDServiceName = "Action";

    public java.lang.String getActionWSDDServiceName() {
        return ActionWSDDServiceName;
    }

    public void setActionWSDDServiceName(java.lang.String name) {
        ActionWSDDServiceName = name;
    }

    public action.Action getAction() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Action_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAction(endpoint);
    }

    public action.Action getAction(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            action.ActionSoapBindingStub _stub = new action.ActionSoapBindingStub(portAddress, this);
            _stub.setPortName(getActionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setActionEndpointAddress(java.lang.String address) {
        Action_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (action.Action.class.isAssignableFrom(serviceEndpointInterface)) {
                action.ActionSoapBindingStub _stub = new action.ActionSoapBindingStub(new java.net.URL(Action_address), this);
                _stub.setPortName(getActionWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Action".equals(inputPortName)) {
            return getAction();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://action", "ActionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://action", "Action"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Action".equals(portName)) {
            setActionEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
