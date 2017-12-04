// Generated code from Butter Knife. Do not modify!
package br.com.paroquiacristooperario.ejc.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import br.com.paroquiacristooperario.ejc.R;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignUpActivity_ViewBinding implements Unbinder {
  private SignUpActivity target;

  private View view2131230755;

  @UiThread
  public SignUpActivity_ViewBinding(SignUpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SignUpActivity_ViewBinding(final SignUpActivity target, View source) {
    this.target = target;

    View view;
    target.celular = Utils.findRequiredViewAsType(source, R.id.cad_celular, "field 'celular'", EditText.class);
    target.data_nascimento = Utils.findRequiredViewAsType(source, R.id.cad_data_nascimento, "field 'data_nascimento'", EditText.class);
    target.edicao = Utils.findRequiredViewAsType(source, R.id.cad_edicao, "field 'edicao'", EditText.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.cad_email, "field 'email'", EditText.class);
    target.nome = Utils.findRequiredViewAsType(source, R.id.cad_nome, "field 'nome'", EditText.class);
    target.senha = Utils.findRequiredViewAsType(source, R.id.cad_senha, "field 'senha'", EditText.class);
    target.telefone = Utils.findRequiredViewAsType(source, R.id.cad_telefone, "field 'telefone'", EditText.class);
    target.sobrenome = Utils.findRequiredViewAsType(source, R.id.cad_sobrenome, "field 'sobrenome'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_cadastrar_final, "method 'cadastrar'");
    view2131230755 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cadastrar();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SignUpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.celular = null;
    target.data_nascimento = null;
    target.edicao = null;
    target.email = null;
    target.nome = null;
    target.senha = null;
    target.telefone = null;
    target.sobrenome = null;

    view2131230755.setOnClickListener(null);
    view2131230755 = null;
  }
}
