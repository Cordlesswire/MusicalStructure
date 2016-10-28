**ESPECIFICAÇÕES DO PROJETO**
Musical Structure

====================================================================================================
**APP DESIGN**
[X] Suitability: A estrutura do app foi desenvolvido para tocar músicas especiais produzidas para ajudar o ouvinte a atingir um estado emocional desejado, uma especie de terapia musical
The app’s structure is suitable for a music player app. A similarly structured app which focuses on audiobooks, podcasts, or other audio media is also acceptable.

[X] Clarity: Usei Toolbar em vez de TextView e isso é aceitável
Each activity is clearly labelled, using a TextView, such that the final purpose of such an activity is easy to understand. For instance, one screen might be labelled ‘song detail screen’ and another might be labelled ‘music library’

[X] Plan for creation:
Any activity that requires an external library or class not yet covered includes the name of that library or class. For instance, a payment screen might include information on how to process the payment.

[X] Number of activities: MainActivity, ItemListActivity, DetailActivity, ItemDetailActivity
The app contains 3 to 6 activities.


====================================================================================================
**LAYOUT**
[X] Structure:
The app contains multiple activities, each labelled, which together make a cohesive music app.

[X] Labelling: Usei Toolbar em vez de TextView e isso é aceitável
Each activity contains a TextView which explains the purpose of the activity.

[] Buttons: Estou considerando o CardView como botão, já que a intensão é ser acionável
Each activity contains buttons which link it to other activities a user should be able to reach from that activity. For instance, a ‘library’ activity might contain a button to move to the ‘now playing’ activity.

[X] Layout Best Practices:
The code adheres to all of the following best practices:
- Text sizes are defined in sp
- Lengths are defined in dp
- Padding and margin is used appropriately, such that the views are not crammed up against each other.


====================================================================================================
**FUNCTIONALITY**
[X] Runtime Errors:
The code runs without errors

[X] OnClickListeners: Não utilizei Button para navegação, fiz dos CardView e item de ListView acionável para navegação
Each button’s behavior is determined by an OnClickListener in the Java code rather than by the android:onClick attribute in the XML Layout.

[X] Intents:
Each button properly opens the intended activity using an explicit Intent.
class ThemeAdapter
private void startActivityOnClick(MyViewHolder holder) {
        final Bundle params = new Bundle();
        params.putString("theme", holder.title.getText().toString());
        //
        holder.thumbnail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Context context = v.getContext();
                Intent intent = new Intent(context, ItemListActivity.class);
                intent.putExtras(params);
                //
                context.startActivity(intent);
            }
        });
        holder.mView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtras(params);
                context.startActivity(intent);
            }
        });
    }


====================================================================================================
**CODE QUALITY**
[X] Code Formatting:
The code is properly formatted i.e. there are no unnecessary blank lines; there are no unused variables or methods; there is no commented out code.
The code also has proper indentation when defining variables and methods.


[X] Readability:
Code is easily readable such that a fellow programmer can understand the purpose of the app.

[X] Naming Conventions:
All variables, methods, and resource IDs are descriptively named such that another developer reading the code can easily understand their function.

