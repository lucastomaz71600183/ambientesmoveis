// Generated code from Butter Knife. Do not modify!
package br.com.paroquiacristooperario.ejc.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import br.com.paroquiacristooperario.ejc.R;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131230751;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnLogin, "field 'btnLogin' and method 'login'");
    target.btnLogin = Utils.castView(view, R.id.btnLogin, "field 'btnLogin'", Button.class);
    view2131230751 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.login();
      }
    });
    target.txtEmail = Utils.findRequiredViewAsType(source, R.id.email, "field 'txtEmail'", TextView.class);
    target.txtSenha = Utils.findRequiredViewAsType(source, R.id.senha, "field 'txtSenha'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnLogin = null;
    target.txtEmail = null;
    target.txtSenha = null;

    view2131230751.setOnClickListener(null);
    view2131230751 = null;
  }
}
