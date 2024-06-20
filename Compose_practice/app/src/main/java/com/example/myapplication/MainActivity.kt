package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun ProductListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Welcome to our Online Store!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("productListDetails") // Navigate to Product List Details
        }) {
            Text("Check Products")
        }
    }
}

@Composable
fun ProductListDetailsScreen(navController: NavController) {
    val productList = listOf("Product 1", "Product 2", "Product 3", "Product 4", "Product 5")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(productList) { product ->
            ProductCard(product = product, onClick = {
                navController.navigate("productDetail/$product") // Navigate to Product Detail
            })
        }
    }
}

@Composable
fun ProductDetailScreen(navController: NavController, productId: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Product Details for: $productId")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("cart") // Navigate to Cart
        }) {
            Text("Add to Cart")
        }
    }
}

@Composable
fun CartScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Your Cart")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("checkout") // Navigate to Checkout
        }) {
            Text("Proceed to Checkout")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.popBackStack("productListDetails", false) // Go back to Product List Details
        }) {
            Text("Continue Shopping")
        }
    }
}

@Composable
fun CheckoutScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Checkout")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.popBackStack("productList", false) // Go back to Product List
        }) {
            Text("Back to Shopping")
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "productList") {
        composable("productList") {
            ProductListScreen(navController)
        }
        composable("productListDetails") {
            ProductListDetailsScreen(navController)
        }
        composable("productDetail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(navController, productId)
        }
        composable("cart") {
            CartScreen(navController)
        }
        composable("checkout") {
            CheckoutScreen(navController)
        }
    }
}

@Composable
fun ProductCard(product: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = product)
    }
}
