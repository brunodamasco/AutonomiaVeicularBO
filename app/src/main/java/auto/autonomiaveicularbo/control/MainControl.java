package auto.autonomiaveicularbo.control;

import android.app.Activity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import auto.autonomiaveicularbo.R;
import auto.autonomiaveicularbo.model.FrotaBO;
import auto.autonomiaveicularbo.model.Veiculo;
import auto.autonomiaveicularbo.model.VeiculoBO;

public class MainControl {
    private Activity activity;
    private EditText editNome;
    private EditText editKm;
    private EditText editCombustivel;
    private TextView tvResultado;
    private LinearLayout lyResultado;
    private FrotaBO frotaBO;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
        frotaBO = new FrotaBO();
    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editKm = activity.findViewById(R.id.editKm);
        editCombustivel = activity.findViewById(R.id.editCombustivel);
        tvResultado = activity.findViewById(R.id.tvResultado);
        lyResultado = activity.findViewById(R.id.lyResultado);
    }

    public void salvarAction(){
        Veiculo v = new Veiculo();
        v.setNome(editNome.getText().toString());
        v.setKm(editKm.getText().toString());
        v.setCombustivel(editCombustivel.getText().toString());
        VeiculoBO vBO = new VeiculoBO(v);

        if (v.getNome().isEmpty()){
            editNome.setError("Digite o nome corretamente");
            editNome.requestFocus();
            return;
        }

        if (!VeiculoBO.validaKm(v)){
            editKm.setError(activity.getString(R.string.msg_erro_km));
            Toast.makeText(activity, R.string.msg_erro_km, Toast.LENGTH_LONG).show();
            return;
        }

        if (!VeiculoBO.validaCom(v)){
            editCombustivel.setError(activity.getString(R.string.msg_erro_combustivel));
            Toast.makeText(activity, R.string.msg_erro_combustivel, Toast.LENGTH_LONG).show();
            return;
        }


        TextView tvNewResultado = new TextView(activity);
        tvNewResultado.setText(frotaBO.toString() + vBO.toString());
        lyResultado.addView(tvNewResultado);


        frotaBO.setvBO(vBO);
        frotaBO.addAutonomia();
        frotaBO.addUnidadeCarro();

        tvResultado.setText("Consumo médio da frota: " + frotaBO.getAutonomiaFrota());
    }

    public void limparForm(){
        editNome.setText("");
        editKm.setText("");
        editCombustivel.setText("");
    }

    public void limparAction(){
        limparForm();
        tvResultado.setText("");
        lyResultado.removeAllViews();

    }
}
