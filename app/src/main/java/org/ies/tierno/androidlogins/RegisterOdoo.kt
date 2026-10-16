package org.ies.tierno.androidlogins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ies.tierno.androidlogins.ui.theme.ui.theme.AndroidLoginsTheme

class RegisterOdoo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidLoginsTheme {
                RegisterOdooContent()
            }
        }
    }
}

@Composable
fun RegisterOdooContent() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(vertical = 24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var repeatPassword by remember { mutableStateOf("") }
            var passwordVisible by remember { mutableStateOf(false) }
            var repeatPasswordVisible by remember { mutableStateOf(false) }
            var firstName by remember { mutableStateOf("") }
            var lastName by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var bio by remember { mutableStateOf("") }
            Image(
                painter = painterResource(id = R.drawable.odoo_logo),
                contentDescription = "Imagen de odoo logo",
                modifier = Modifier
                    .height(50.dp),
                contentScale = ContentScale.Fit

            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = username,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                onValueChange = { username = it },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Username"
                        )
                        Text("Nombre de usuario")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = password,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                onValueChange = { password = it },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Contraseña"
                        )
                        Text("Contraseña")
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }

            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = repeatPassword,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                onValueChange = { repeatPassword = it },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "ContraseñaRepeat"
                        )
                        Text("Repita la contraseña")
                    }
                },
                visualTransformation = if (repeatPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (repeatPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { repeatPasswordVisible = !repeatPasswordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                TextField(
                    value = firstName,

                    singleLine = true,
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f),
                    onValueChange = { firstName = it },
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Nombre")
                        }
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))

                TextField(
                    value = lastName,
                    singleLine = true,

                    modifier = Modifier
                        .padding(10.dp)
                        .weight(2f),

                    onValueChange = { lastName = it },
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Apellidos")
                        }
                    }
                )

            }
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = email,
                singleLine = true,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),

                onValueChange = { email = it },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email"
                        )
                        Text("Email")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = bio,
                singleLine = false,

                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp),

                onValueChange = { bio = it },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.TextFields,
                            contentDescription = "Bio"
                        )
                        Text("Bio")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        username = ""
                        password = ""
                        repeatPassword = ""
                        firstName = ""
                        lastName = ""
                        email = ""
                        bio = ""
                        passwordVisible = false
                        repeatPasswordVisible = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF714B67))
                ) {

                    Text("Limpiar")
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "limpiar"
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))

                Button(onClick = { /* Acción */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF714B67))

                ) {
                    Text("Aceptar")
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "limpiar"
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterOdooContentPreview() {
    AndroidLoginsTheme {
        RegisterOdooContent()
    }
}