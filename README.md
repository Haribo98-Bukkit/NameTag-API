NameTag-API
===========

How to use NameTag API.

<h3>Using the Event</h3>
<pre>
public void onTagReceive(NameTagReceiveEvent event) {
	event.setNameTag(ChatColor.COLOR + event.getPlayer());
}
</pre>

<h3>Using the Method</h3>
<pre>
PlayerTag tag = new PlayerTag(player);
tag.setNameTag(ChatColor.COLOR + player.getName());
</pre>

Along with,
<pre>
.setNameTag(ChatColor.COLOR + player.getName());
</pre>

there is also,
<pre>
.setNameColor(ChatColor.COLOR);
</pre>

or

<pre>
.setNameColour(ChatColor.COLOUR);
</pre>

if prefered!
