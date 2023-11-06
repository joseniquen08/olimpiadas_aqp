package pe.edu.utp.olimpiadas_aqp.models.responses.user;

import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.ClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.GetClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.DelegateRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.GetDelegateRes;

public class UserRes {
    private Long userId;
    private String email;
    private String fullName;
    private String roleName;
    private GetClientRes client;
    private GetDelegateRes delegate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public GetClientRes getClient() {
        return client;
    }

    public void setClient(GetClientRes client) {
        this.client = client;
    }

    public GetDelegateRes getDelegate() {
        return delegate;
    }

    public void setDelegate(GetDelegateRes delegate) {
        this.delegate = delegate;
    }
}
