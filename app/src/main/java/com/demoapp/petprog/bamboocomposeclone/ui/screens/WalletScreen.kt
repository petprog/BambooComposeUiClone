package com.demoapp.petprog.bamboocomposeclone.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.demoapp.petprog.bamboocomposeclone.ui.widgets.StockItem
import com.demoapp.petprog.bamboocomposeclone.ui.widgets.WalletView
import com.demoapp.petprog.bamboocomposeclone.ui.widgets.stockItem
import com.demoapp.petprog.bamboocomposeclone.R
import com.demoapp.petprog.bamboocomposeclone.ui.widgets.Chip
import com.demoapp.petprog.bamboocomposeclone.common.dividerColor
import com.demoapp.petprog.bamboocomposeclone.common.BambooComposeCloneTheme

val stockGroup = listOf(
    "All-Stocks",
    "Technology",
    "Medical",
    "Entertainment"
)
val colors = listOf(
    Color(0xFFDB5DBD),
    Color(0xFF025889),
    Color(0xFFAB75FB),
    Color(0xFFED1D23)

)
var dummyStocks = listOf(
    StockItem(R.drawable.facebook, "Facebook", "FB", "$30.78"),
    StockItem(R.drawable.slack, "Slack Technologies", "SLK", "$100.78"),
    StockItem(R.drawable.google, "Google", "GO", "$110.78"),
    StockItem(R.drawable.tesla, "Tesla", "TSLA", "$500.78"),
    StockItem(R.drawable.facebook, "Facebook", "FB", "$30.78"),
    StockItem(R.drawable.slack, "Slack Technologies", "SLK", "$100.78"),
    StockItem(R.drawable.google, "Google", "GO", "$110.78"),
    StockItem(R.drawable.tesla, "Tesla", "TSLA", "$500.78")
)


@Composable
fun chipList() {
    val scrollState = rememberLazyListState()
    LazyRow(state = scrollState) {
        items(count = stockGroup.size) { index ->
            Chip(
                text = stockGroup[index],
                color = colors[index]
            )
        }
    }

}

@Composable
fun stockView() {
    Column(
        modifier = Modifier
            .padding(15.dp),
    ) {
        ConstraintLayout(Modifier.fillMaxWidth()) {
            val (featured, seeAll, description) = createRefs()
            Text(
                "Featured Themes", Modifier.constrainAs(featured){
                    start.linkTo(parent.start)
                },
                style = MaterialTheme.typography.h1.copy(fontSize = 16.sp)

            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "See All", Modifier.constrainAs(seeAll){
                    end.linkTo(parent.end)
                    top.linkTo(featured.top)
                },
                style = MaterialTheme.typography.body1.copy(fontSize = 14.sp, color = MaterialTheme.colors.primary),

                )
            Text(
                "Check out this categories to discover new stocks", Modifier.constrainAs(description){
                    start.linkTo(parent.start)
                    top.linkTo(featured.bottom)
                },
                style = MaterialTheme.typography.body1.copy(fontSize = 12.sp)

            )
        }
        Spacer(Modifier.height(10.dp))
        chipList()
        Spacer(Modifier.height(30.dp))
        Text(
            "My Stocks",
            style = MaterialTheme.typography.h1.copy(fontSize = 16.sp)
        )
        Spacer(Modifier.height(15.dp))


    }

}

@Preview(showBackground = true)
@Composable
fun WalletScreen() {
    val scrollListState = rememberLazyListState()
    BambooComposeCloneTheme() {
        LazyColumn(state = scrollListState) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    WalletView()
                }
            }
            item {
                stockView()
            }
            items(count = dummyStocks.size) { index ->
                Divider(modifier = Modifier.padding(horizontal = 15.dp),  color = dividerColor, thickness = 0.5.dp)
                stockItem(
                    stockImage = dummyStocks[index].icon,
                    name = dummyStocks[index].name,
                    symbol = dummyStocks[index].symbol,
                    amount = dummyStocks[index].amount
                )
                Divider(modifier = Modifier.padding(horizontal = 15.dp),color = dividerColor, thickness = 0.5.dp)
            }
            item {
                Spacer(Modifier.height(40.dp))
            }
        }
    }

}