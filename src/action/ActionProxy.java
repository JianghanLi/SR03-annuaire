package action;

public class ActionProxy implements action.Action {
  private String _endpoint = null;
  private action.Action action = null;
  
  public ActionProxy() {
    _initActionProxy();
  }
  
  public ActionProxy(String endpoint) {
    _endpoint = endpoint;
    _initActionProxy();
  }
  
  private void _initActionProxy() {
    try {
      action = (new action.ActionServiceLocator()).getAction();
      if (action != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)action)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)action)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (action != null)
      ((javax.xml.rpc.Stub)action)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public action.Action getAction() {
    if (action == null)
      _initActionProxy();
    return action;
  }
  
  public void deleteAnnonce(int id_annonce) throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    action.deleteAnnonce(id_annonce);
  }
  
  public java.lang.String test() throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    return action.test();
  }
  
  public java.lang.String searchByCategorie(java.lang.String categorie) throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    return action.searchByCategorie(categorie);
  }
  
  public void newAnnonce(java.lang.String categorie, java.lang.String nom, java.lang.String rue, java.lang.String ville, java.lang.String postal, java.lang.String tele, java.lang.String text) throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    action.newAnnonce(categorie, nom, rue, ville, postal, tele, text);
  }
  
  public void modifyAnnonce(java.lang.String categorie, java.lang.String nom, java.lang.String rue, java.lang.String ville, java.lang.String postal, java.lang.String tele, java.lang.String text, int id_annonce) throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    action.modifyAnnonce(categorie, nom, rue, ville, postal, tele, text, id_annonce);
  }
  
  public void newCategorie(java.lang.String categorie) throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    action.newCategorie(categorie);
  }
  
  public void modifyCategorie(java.lang.String categorie, java.lang.String newCategorie) throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    action.modifyCategorie(categorie, newCategorie);
  }
  
  public void deleteCategorie(java.lang.String categorie) throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    action.deleteCategorie(categorie);
  }
  
  public java.lang.String searchByCodepostal(java.lang.String codePostal) throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    return action.searchByCodepostal(codePostal);
  }
  
  public java.lang.String searchByNom(java.lang.String nom) throws java.rmi.RemoteException{
    if (action == null)
      _initActionProxy();
    return action.searchByNom(nom);
  }
  
  
}