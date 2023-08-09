package com.example.equaltoequal_20.drawerNav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.equaltoequal_20.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerSheet(
    route: String,
    navigateToHome: () -> Unit = {},
    navigateToSettings: () -> Unit = {},
    closeDrawer: () -> Unit = {}
) {
    ModalDrawerSheet(drawerShape = RectangleShape, modifier = Modifier.fillMaxWidth(0.75f)) {
        DrawerHeader()
//        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_padding)))
        NavigationDrawerItem(
            modifier = Modifier.padding(5.dp),
            label = {
                Text(
                    text = stringResource(id = R.string.allProjects),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            selected = route == AllDestinations.HOME,
            onClick = {
                navigateToHome()
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            modifier = Modifier.padding(5.dp),
            label = { Text(text = stringResource(id = R.string.myProjects), style = MaterialTheme.typography.labelLarge) },
            selected = route == AllDestinations.SETTINGS,
            onClick = {
                navigateToSettings()
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            modifier = Modifier.padding(5.dp),
            label = { Text(text = stringResource(id = R.string.inActive), style = MaterialTheme.typography.labelLarge) },
            selected = false,
            onClick = {
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            modifier = Modifier.padding(5.dp),
            label = { Text(text = stringResource(id = R.string.settings), style = MaterialTheme.typography.labelLarge) },
            selected = false,
            onClick = {
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        Divider(color = Gray, thickness = 1.dp)

        NavigationDrawerItem(
            modifier = Modifier.padding(5.dp),
            label = { Text(text = stringResource(id = R.string.mustHave), style = MaterialTheme.typography.labelLarge) },
            selected = false,
            onClick = {
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )
    }
}


@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .fillMaxWidth()
            .height(290.dp)
    ) {
        Image(
            painterResource(id = R.drawable.back),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.Start,
//        modifier = Modifier
//            .background(MaterialTheme.colorScheme.secondary)
//            .padding(dimensionResource(id = R.dimen.header_padding))
//            .fillMaxWidth()
//    ) {
//
//        Image(
//            painterResource(id = R.drawable.profile_picture),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(dimensionResource(id = R.dimen.header_image_size))
//                .clip(CircleShape)
//        )
//        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_padding)))
//
//        Text(
//            text = stringResource(id = R.string.app_name),
//            textAlign = TextAlign.Center,
//            style = MaterialTheme.typography.bodyLarge,
//            color = MaterialTheme.colorScheme.onPrimary,
//        )
//    }
}

@Preview
@Composable
fun DrawerHeaderPreview() {
    DrawerSheet(route = AllDestinations.HOME)
}