// Generated code from Butter Knife. Do not modify!
package br.com.paroquiacristooperario.ejc.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import br.com.paroquiacristooperario.ejc.R;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileActivity_ViewBinding implements Unbinder {
  private ProfileActivity target;

  @UiThread
  public ProfileActivity_ViewBinding(ProfileActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileActivity_ViewBinding(ProfileActivity target, View source) {
    this.target = target;

    target.nome = Utils.findRequiredViewAsType(source, R.id.nome, "field 'nome'", EditText.class);
    target.sobrenome = Utils.findRequiredViewAsType(source, R.id.sobrenome, "field 'sobrenome'", EditText.class);
    target.telefone = Utils.findRequiredViewAsType(source, R.id.telefone, "field 'telefone'", EditText.class);
    target.celular = Utils.findRequiredViewAsType(source, R.id.celular, "field 'celular'", EditText.class);
    target.data_nascimento = Utils.findRequiredViewAsType(source, R.id.data_nascimento, "field 'data_nascimento'", EditText.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.prof_email, "field 'email'", EditText.class);
    target.foto = Utils.findRequiredViewAsType(source, R.id.prof_foto, "field 'foto'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfileActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nome = null;
    target.sobrenome = null;
    target.telefone = null;
    target.celular = null;
    target.data_nascimento = null;
    target.email = null;
    target.foto = null;
  }
}
